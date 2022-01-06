package com.albo.marvel.dto;

import java.util.ArrayList;
import java.util.List;

public class CharacterItem {

	public String character;
	public List<String> comics;

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public List<String> getComics() {
		comics = (comics == null) ? new ArrayList<>() :comics;
		return comics;
	}

	public void setComics(List<String> comics) {
		this.comics = comics;
	}
}
