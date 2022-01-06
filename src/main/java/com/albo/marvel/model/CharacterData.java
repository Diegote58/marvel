package com.albo.marvel.model;

import java.util.List;

public class CharacterData {
	public int offset;
	public int limit;
	public int total;
	public int count;
	public List<CharacterResult> results;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CharacterResult> getResults() {
		return results;
	}

	public void setResults(List<CharacterResult> results) {
		this.results = results;
	}
}
