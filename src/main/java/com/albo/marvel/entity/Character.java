package com.albo.marvel.entity;

import com.albo.marvel.model.CharacterResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Character {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;

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

	public Character(){}

	public Character(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Character(CharacterResult character) {
		this.id = character.getId();
		this.name = character.getName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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