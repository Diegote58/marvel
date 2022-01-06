package com.albo.marvel.entity;

import com.albo.marvel.model.ComicCreatorItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Colaborator {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="name", columnDefinition = "varchar(255) not null")
	private String name;

	@Column(name="role", columnDefinition = "varchar(255) not null")
	private String role;

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

	@JsonIgnore
	@OneToMany(mappedBy = "colaborator", fetch= FetchType.LAZY)
	private List<ComicHasColaborator> comicHasColaboratorList;

	public Colaborator() {}

	public Colaborator(Long id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<ComicHasColaborator> getComicHasColaboratorList() {
		return comicHasColaboratorList;
	}

	public void setComicHasColaboratorList(List<ComicHasColaborator> comicHasColaboratorList) {
		this.comicHasColaboratorList = comicHasColaboratorList;
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