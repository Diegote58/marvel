package com.albo.marvel.service;

import org.springframework.transaction.annotation.Transactional;
import java.net.URISyntaxException;

public interface ComicService {

	@Transactional
	void Syncronize(long characterId) throws URISyntaxException;
}
