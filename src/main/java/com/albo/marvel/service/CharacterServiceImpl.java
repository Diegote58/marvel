package com.albo.marvel.service;


import com.albo.marvel.dto.CharacterResponse;
import com.albo.marvel.dto.converter.CharacterResponseConverter;
import com.albo.marvel.entity.Character;
import com.albo.marvel.entity.CharacterConfig;
import com.albo.marvel.entity.ComicHasCharacter;
import com.albo.marvel.exception.NotFoundException;
import com.albo.marvel.model.ComicCharacterItem;
import com.albo.marvel.repository.CharacterRepository;
import com.albo.marvel.restClientService.MarvelRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Resource
	CharacterRepository characterRepository;

	@Resource
	CharacterConfigService characterConfigService;

	@Resource
	ComicsHasCharacterService comicsHasCharacterService;

	@Resource
	CharacterResponseConverter characterResponseConverter;

	@Resource
	MarvelRestClient marvelRestClient;

	@Value("${marvel-private-key}")
	private String privateKey;

	@Value("${marvel-public-key}")
	private String publicKey;

	@Value("${marvel-url-request}")
	private String urlRequest;

	@Override
	public Character create(ComicCharacterItem characterItem) {
		String[] split = characterItem.resourceURI.split("/");
		long id = Long.parseLong(split[split.length - 1]);
		Character character = getById(id);
		if (character == null) {
			character = characterRepository.save(new Character(id, characterItem.getName()));
		}
		return character;
	}

	@Override
	public Character getById(Long id) {
		return characterRepository.findById(id).orElse(null);
	}

	@Override
	public CharacterResponse listCharacters(String code) {
		CharacterConfig character = characterConfigService.getByCode(code);
		if (character == null) {
			throw new NotFoundException("character code: " + code + " not found");
		}

		List<ComicHasCharacter> comicHasCharacterDtoList = comicsHasCharacterService.findCharactersRelationshipByCharacterId(character.getId());

		return characterResponseConverter.ToCharacterResponse(comicHasCharacterDtoList);
	}
}
