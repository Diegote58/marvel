package com.albo.marvel.service;


import com.albo.marvel.entity.CharacterConfig;
import com.albo.marvel.repository.CharacterConfigRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CharacterConfigServiceImpl implements CharacterConfigService {


	@Resource
	CharacterConfigRepository configCharacterRepository;

	@Override
	public CharacterConfig getByCode(String code) {
		return configCharacterRepository.getByCode(code);
	}

	@Override
	public List<CharacterConfig> findAll() {
		return configCharacterRepository.findAll();
	}

}
