package com.albo.marvel.model;

import java.util.List;

public class ComicCreator {

	private int available;
	private int returned;
	private List<ComicCreatorItem> items;

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

	public List<ComicCreatorItem> getItems() {
		return items;
	}

	public void setItems(List<ComicCreatorItem> items) {
		this.items = items;
	}
}
