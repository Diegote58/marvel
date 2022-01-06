package com.albo.marvel.service;


import com.albo.marvel.constants.Constants;
import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.entity.Comic;
import com.albo.marvel.entity.ComicHasColaborator;
import com.albo.marvel.model.ComicCreatorItem;
import com.albo.marvel.model.ComicResult;
import com.albo.marvel.repository.ComicHasColaboratorRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComicHasColaboratorServiceImpl implements ComicHasColaboratorService {


	@Resource
	ComicHasColaboratorRepository comicHasColaboratorRepository;

	@Resource
	CollaboratorService colaboratorService;

	@Override
	public ComicHasColaborator create(Comic comic, Colaborator colaborator) {
		ComicHasColaborator comicHasColaborator = comicHasColaboratorRepository.findByComicIdAndColaboratorId(comic.getId(), colaborator.getId());
		if (comicHasColaborator == null) {
			comicHasColaborator = comicHasColaboratorRepository.save(new ComicHasColaborator(comic, colaborator));
		}
		return comicHasColaborator;
	}

}
