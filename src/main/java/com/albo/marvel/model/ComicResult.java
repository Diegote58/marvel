package com.albo.marvel.model;

public class ComicResult {

	private long id;
	private String title;
	private String description;
	private String modified;
	private ComicCreator creators;
	private ComicCharacter characters;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public ComicCreator getCreators() {
		return creators;
	}

	public void setCreators(ComicCreator creators) {
		this.creators = creators;
	}

	public ComicCharacter getCharacters() {
		return characters;
	}

	public void setCharacters(ComicCharacter characters) {
		this.characters = characters;
	}
}
