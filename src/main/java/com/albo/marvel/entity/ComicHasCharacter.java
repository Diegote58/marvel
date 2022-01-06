package com.albo.marvel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class ComicHasCharacter {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "comic_id", columnDefinition = "int null")
	private Comic comic;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "character_id", columnDefinition = "int not null")
	private Character character;

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

	public ComicHasCharacter(){}

	public ComicHasCharacter(Comic comic, Character character) {
		this.comic = comic;
		this.character = character;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
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
}