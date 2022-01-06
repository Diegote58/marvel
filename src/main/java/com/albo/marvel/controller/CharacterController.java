package com.albo.marvel.controller;

import com.albo.marvel.dto.CharacterResponse;
import com.albo.marvel.service.CharacterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/marvel")
public class CharacterController {

	@Resource
	CharacterService characterService;

	@RequestMapping(value = "/characters/{code}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8" })
	public CharacterResponse searchCharacters(@PathVariable(name = "code", required = true) String code) {
		return characterService.listCharacters(code);
	}

}
