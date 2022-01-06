package com.albo.marvel.model;

import java.util.List;

public class ComicCharacter {

	private int available;
	private int returned;
	private List<ComicCharacterItem> items;

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getReturned() {
		return returned;
	}

	public void setReturned(int returned) {
		this.returned = returned;
	}

	public List<ComicCharacterItem> getItems() {
		return items;
	}

	public void setItems(List<ComicCharacterItem> items) {
		this.items = items;
	}
}
