package com.albo.marvel.dto;

import java.util.ArrayList;
import java.util.List;

public class ColaboratorResponse {

	public String lastSync;
	public List<String> editors;
	public List<String> writers;
	public List<String> colorists;

	public String getLastSync() {
		return lastSync;
	}

	public void setLastSync(String lastSync) {
		this.lastSync = lastSync;
	}

	public List<String> getEditors() {
		editors = (editors==null)?new ArrayList<>() :editors;
		return editors;
	}

	public void setEditors(List<String> editors) {
		this.editors = editors;
	}

	public List<String> getWriters() {
		writers = (writers==null)?new ArrayList<>() :writers;
		return writers;
	}

	public void setWriters(List<String> writers) {
		this.writers = writers;
	}

	public List<String> getColorists() {
		colorists = (colorists==null)?new ArrayList<>() :colorists;
		return colorists;
	}

	public void setColorists(List<String> colorists) {
		this.colorists = colorists;
	}
}
