package com.projectlinkapi.web.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projectlinkapi.model.Link;
import com.sun.istack.NotNull;

public class LinkForm {
 
    private Long idUser;
	@NotNull @NotEmpty @Length(min = 5)
    private String title;
	@NotNull @NotEmpty @Length(min = 5)
    private String description;

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

	public Link toEntity() {
		return new Link(getTitle(),getDescription());
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "LinkForm [idUser=" + idUser + ", title=" + title + ", description=" + description + "]";
	}
}
