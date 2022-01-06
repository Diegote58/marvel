package com.albo.marvel.controller;

import com.albo.marvel.dto.ColaboratorResponse;
import com.albo.marvel.service.CollaboratorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/marvel")
public class ColaboratorController {

	@Resource
	CollaboratorService colaboratorService;

	@RequestMapping(value = "/colaborators/{code}", method = RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
	public ColaboratorResponse createCollaborators(@PathVariable String code) {
		return colaboratorService.listColaborators(code);
	}

}
