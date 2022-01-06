package com.albo.marvel.dto;

import java.util.ArrayList;
import java.util.List;

public class CharacterResponse {

	public String lastSync;
	public List<CharacterItem> characters;


	public String getLastSync() {
		return lastSync;
	}

	public void setLastSync(String lastSync) {
		this.lastSync = lastSync;
	}

	public List<CharacterItem> getCharacters() {
		characters = (characters==null)?new ArrayList<>() :characters;
		return characters;
	}

	public void setCharacters(List<CharacterItem> characters) {
		this.characters = characters;
	}

}
