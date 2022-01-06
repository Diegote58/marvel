package com.albo.marvel.service;

import com.albo.marvel.entity.CharacterConfig;

import java.util.List;

public interface CharacterConfigService {

	CharacterConfig getByCode(String code);

	List<CharacterConfig> findAll();

}
