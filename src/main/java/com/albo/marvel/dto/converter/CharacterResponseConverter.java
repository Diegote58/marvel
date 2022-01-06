package com.albo.marvel.dto.converter;

import com.albo.marvel.constants.Constants;
import com.albo.marvel.dto.CharacterItem;
import com.albo.marvel.dto.CharacterResponse;
import com.albo.marvel.entity.Character;
import com.albo.marvel.entity.ComicHasCharacter;
import com.albo.marvel.utils.UtilDate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacterResponseConverter {

	public CharacterResponse ToCharacterResponse(List<ComicHasCharacter> comicHasCharacters) {
		CharacterResponse characterResponse = new CharacterResponse();
		if (comicHasCharacters != null && !comicHasCharacters.isEmpty()) {
			characterResponse.setLastSync(Constants.LAST_SYNC_PREFIX + UtilDate.getFormatDate(comicHasCharacters.get(0).getLastModified(), Constants.LAST_SYNC_FORMAT_DATE));
			List<Character> characters = comicHasCharacters.stream().map(ComicHasCharacter::getCharacter).distinct().collect(Collectors.toList());
			for (Character c: characters) {
				boolean exist = characterResponse.getCharacters().stream()
								.anyMatch(cr -> cr.getCharacter().equalsIgnoreCase(c.getName()));
				if (!exist) {
					CharacterItem item = new CharacterItem();
					item.setCharacter(c.getName());
					List<String> comics = comicHasCharacters.stream()
								.filter(co -> co.getCharacter().getId() == c.getId())
								.map(chc -> chc.getComic().getTitle())
								.distinct()
								.collect(Collectors.toList());
					if (comics != null && !comics.isEmpty()) {
						item.setComics(comics);
					}
					characterResponse.getCharacters().add(item);
				}
			}
		}
		return characterResponse;
	}
}
