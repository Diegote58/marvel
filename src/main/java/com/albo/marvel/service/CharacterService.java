package com.albo.marvel.service;

import com.albo.marvel.dto.CharacterResponse;
import com.albo.marvel.entity.Character;
import com.albo.marvel.model.ComicCharacterItem;

public interface CharacterService {

	Character getById(Long id);

	Character create(ComicCharacterItem characterItem);

	CharacterResponse listCharacters(String code);
}
