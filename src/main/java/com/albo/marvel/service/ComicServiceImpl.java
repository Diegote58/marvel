package com.albo.marvel.service;


import com.albo.marvel.constants.Constants;
import com.albo.marvel.entity.Character;
import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.entity.Comic;
import com.albo.marvel.model.ComicCharacterItem;
import com.albo.marvel.model.ComicCreatorItem;
import com.albo.marvel.model.ComicResult;
import com.albo.marvel.model.ComicSearchResponse;
import com.albo.marvel.repository.ComicRepository;
import com.albo.marvel.restClientService.MarvelRestClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestClientException;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	ComicRepository comicRepository;

	@Resource
	CollaboratorService collaboratorService;

	@Resource
	CharacterService characterService;

	@Resource
	ComicHasColaboratorService comicHasColaboratorService;

	@Resource
	ComicsHasCharacterService comicsHasCharacterService;

	@Resource
	MarvelRestClient marvelRestClient;

	@Value("${marvel-private-key}")
	private String privateKey;

	@Value("${marvel-public-key}")
	private String publicKey;

	@Value("${marvel-url-request}")
	private String urlRequest;

	private Comic create(Comic comic) {
		Comic newComic = comicRepository.findById(comic.getId()).orElse(null);
		if (newComic == null || !newComic.equals(comic)) {
			newComic = comicRepository.save(comic);
		}
		return newComic;
	}

	@Override
	@Transactional
	public void Syncronize(long characterId) throws URISyntaxException {
		long ts = System.currentTimeMillis();

		String auth = ts + privateKey + publicKey;
		String hash = DigestUtils.md5DigestAsHex(auth.getBytes());

		int limit = Constants.LIMIT;
		int offset = 0;
		boolean process = true;

		while (process) {
			String url = urlRequest + "/characters/" + characterId + "/comics?limit=" + limit + "&offset=" + offset + "&ts=" + ts + "&apikey=" + publicKey + "&hash=" + hash;
			ResponseEntity<ComicSearchResponse> response = null;
			try {
				response = (ResponseEntity<ComicSearchResponse>) marvelRestClient.makeRequest(new URI(url), ComicSearchResponse.class);
				if (response != null) {
					if (response.getStatusCodeValue() == 200) {
						logger.info("Syncronize - url: " + url + "" + response.getStatusCodeValue());
						syncronizeComics(response);
					}
				}
			} catch (RestClientException e) {
				logger.error("Syncronize - url: " + url, e);
			}

			if ((limit+offset) >= response.getBody().getData().getTotal()) {
				process = false;
			}

			offset = offset + limit;
		}
	}

	void syncronizeComics(ResponseEntity<ComicSearchResponse> response) {
		ComicSearchResponse comicSearchResponse = response.getBody();
		List<ComicResult> comicList = comicSearchResponse.getData().getResults();
		for (ComicResult comic : comicList) {
			Comic newComic = create(new Comic(comic, comicSearchResponse.getEtag()));
			if (newComic != null) {
				logger.info("syncronizeComics: " + newComic.getId() + " - " + newComic.getTitle());
				syncronizeColaborators(comic, newComic);
				syncronizeCharacters(comic, newComic);
			}
		}
	}

	void syncronizeColaborators(ComicResult comic, Comic newComic) {
		for (ComicCreatorItem creatorItem : comic.getCreators().getItems()) {
			if (Constants.VALID_ROLE_COLABORATORS.contains(creatorItem.role)) {
				List<Colaborator> colaborators = collaboratorService.findByRoleAndName(creatorItem.role, creatorItem.name);
				if (colaborators == null || colaborators.isEmpty()) {
					Colaborator colaborator = collaboratorService.create(creatorItem);
					if (colaborator != null) {
						logger.info("syncronizeColaborators: " + colaborator.getName() + " - " + colaborator.getRole());
						comicHasColaboratorService.create(newComic, colaborator);
					}
				}
			}
		}
	}

	void syncronizeCharacters(ComicResult comic, Comic newComic) {
		for (ComicCharacterItem characterItem : comic.getCharacters().getItems()) {
			Character character = characterService.create(characterItem);
			if (character != null) {
				logger.info("syncronizeCharacters: " + character.getId() + " - " + character.getName());
				comicsHasCharacterService.create(newComic, character);
			}
		}
	}
}
