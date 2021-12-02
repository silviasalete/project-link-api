package com.projectlinkapi.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
    
    @ManyToOne
    private User    createdBy;
    private Date    createdIn;
    
    @ManyToOne
    private User    updatedBy;
    private Date    updatedIn;

	public Item() {
		super();
	}

	public Item(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Item(Long id, String title, String description, User createdBy, Date createdIn, User updatedBy,
			Date updatedIn) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdBy = createdBy;
		this.createdIn = createdIn;
		this.updatedBy = updatedBy;
		this.updatedIn = updatedIn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(Date createdIn) {
		this.createdIn = createdIn;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedIn() {
		return updatedIn;
	}

	public void setUpdatedIn(Date updatedIn) {
		this.updatedIn = updatedIn;
	}
	
}
