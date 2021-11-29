package com.projectbasicapi.web.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.projectbasicapi.model.Item;
import com.sun.istack.NotNull;

public class ItemForm {

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

	public Item toEntity() {
		return new Item(getTitle(),getDescription());
	}

	@Override
	public String toString() {
		return "ItemForm [title=" + title + ", description=" + description + "]";
	}

}
