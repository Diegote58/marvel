package com.albo.marvel.service;

import com.albo.marvel.dto.ColaboratorResponse;
import com.albo.marvel.entity.Colaborator;
import com.albo.marvel.model.ComicCreatorItem;

import java.util.List;

public interface CollaboratorService {

	Colaborator create(ComicCreatorItem item);

	List<Colaborator> findByRoleAndName(String role, String name);

	ColaboratorResponse listColaborators(String code);
}
