package com.albo.marvel.service;


import com.albo.marvel.constants.Constants;
import com.albo.marvel.entity.Character;
import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.entity.Comic;
import com.albo.marvel.entity.ComicHasCharacter;
import com.albo.marvel.model.ComicCreatorItem;
import com.albo.marvel.model.ComicResult;
import com.albo.marvel.repository.ComicsHasCharacterRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ComicsHasCharacterServiceImpl implements ComicsHasCharacterService {

	@Resource
	ComicsHasCharacterRepository comicsHasCharacterRepository;

	@Override
	public ComicHasCharacter create(Comic comic, Character character) {
		ComicHasCharacter comicsHasCharacter = comicsHasCharacterRepository.findByComicIdAndCharacterId(comic.getId(), character.getId());
		if (comicsHasCharacter == null) {
			comicsHasCharacter = comicsHasCharacterRepository.save(new ComicHasCharacter(comic, character));
		}
		return comicsHasCharacter;
	}

	@Override
	public List<ComicHasCharacter> findCharactersRelationshipByCharacterId(Long characterId) {
		return comicsHasCharacterRepository.findCharactersRelationshipByCharacterId(characterId);
	}




}
