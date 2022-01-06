package com.albo.marvel.entity;

import com.albo.marvel.model.ComicResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comic {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="title", columnDefinition = "Text")
	private String title;

	@Column(name="etag", columnDefinition = "varchar(255)")
	private String etag;

	@JsonIgnore
	@OneToMany(mappedBy = "comic", fetch= FetchType.LAZY)
	private List<ComicHasColaborator> comicHasColaboratorList;

	@JsonIgnore
	@OneToMany(mappedBy = "comic", fetch= FetchType.LAZY)
	private List<ComicHasCharacter> comicsHasCharacterList;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_created")
	@LastModifiedDate
	private Date dateCreated;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified")
	@LastModifiedDate
	private Date lastModified;

	public Comic() {}

	public Comic(ComicResult comicResult, String etag) {
		this.id = comicResult.getId();
		this.title = comicResult.getTitle();
		this.etag = etag;
	}

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

	public List<ComicHasColaborator> getComicHasColaboratorList() {
		return comicHasColaboratorList;
	}

	public void setComicHasColaboratorList(List<ComicHasColaborator> comicHasColaboratorList) {
		this.comicHasColaboratorList = comicHasColaboratorList;
	}

	public List<ComicHasCharacter> getComicsHasCharacterList() {
		return comicsHasCharacterList;
	}

	public void setComicsHasCharacterList(List<ComicHasCharacter> comicsHasCharacterList) {
		this.comicsHasCharacterList = comicsHasCharacterList;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}
}