package com.albo.marvel.scheduled;

import com.albo.marvel.entity.CharacterConfig;
import com.albo.marvel.service.ComicService;
import com.albo.marvel.service.CharacterConfigService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class ScheduledTaskService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	ComicService comicService;

	@Resource
	CharacterConfigService configCharacterService;

	@Scheduled(cron="${cron.expression.syncronize}")
	public void runSync() throws URISyntaxException {
		List<CharacterConfig> configCharacter = configCharacterService.findAll();
		for (CharacterConfig c : configCharacter) {
			logger.info("runSync code: " + c.getCode() + " - name: " + c.getName());
			comicService.Syncronize(c.getId());
		}
		logger.info("runSync end - processed: " + configCharacter.size());
	}
}
