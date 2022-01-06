package com.albo.marvel.service;


import com.albo.marvel.dto.ColaboratorResponse;
import com.albo.marvel.dto.converter.ColaboratorResponseConverter;
import com.albo.marvel.entity.CharacterConfig;
import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.exception.NotFoundException;
import com.albo.marvel.model.ComicCreatorItem;
import com.albo.marvel.repository.ColaboratorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

	@Resource
	ColaboratorRepository collaboratorRepository;

	@Resource
	CharacterConfigService characterConfigService;

	@Resource
	ColaboratorResponseConverter colaboratorResponseConverter;

	@Override
	public List<Colaborator> findByRoleAndName(String role, String name) {
		return collaboratorRepository.findByRoleAndName(role, name);
	}

	@Override
	@Transactional
	public Colaborator create(ComicCreatorItem item) {
		String[] split = item.resourceURI.split("/");
		Long  colaboratorId = Long.parseLong(split[split.length - 1]);
		Colaborator colaborator = collaboratorRepository.findById(colaboratorId).orElse(null);
		if (colaborator == null) {
			colaborator = new Colaborator(colaboratorId, item.getName(), item.getRole());
		}

		return collaboratorRepository.save(colaborator);
	}

	@Override
	public ColaboratorResponse listColaborators(String code) {
		CharacterConfig characterConfig = characterConfigService.getByCode(code);
		if (characterConfig == null) {
			throw new NotFoundException("character code: " + code + " not found");
		}
		List<Colaborator> colaborators = collaboratorRepository.findByCharacterId(characterConfig.getId());

		return colaboratorResponseConverter.toColaboratorResponse(colaborators);
	}


}
