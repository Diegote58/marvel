package com.albo.marvel.service;

import com.albo.marvel.entity.Character;
import com.albo.marvel.entity.Comic;
import com.albo.marvel.entity.ComicHasCharacter;

import java.util.List;

public interface ComicsHasCharacterService {

	ComicHasCharacter create(Comic comic, Character character);

	List<ComicHasCharacter> findCharactersRelationshipByCharacterId(Long characterId);

}
