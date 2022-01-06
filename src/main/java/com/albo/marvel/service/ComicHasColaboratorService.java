package com.albo.marvel.service;

import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.entity.Comic;
import com.albo.marvel.entity.ComicHasColaborator;
import com.albo.marvel.model.ComicResult;

public interface ComicHasColaboratorService {

	ComicHasColaborator create(Comic comic, Colaborator collaborator);

}
