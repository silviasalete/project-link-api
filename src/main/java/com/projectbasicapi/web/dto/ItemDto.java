package com.projectbasicapi.web.dto;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.projectbasicapi.model.Item;

public class ItemDto {

	private Long id;
    private String title;
    private String description;
	
	public ItemDto() {
		super();
	}

	public ItemDto(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
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

	public static ItemDto toDto(Item item) {
		
		return new ItemDto(item.getId(), item.getTitle(), item.getDescription());
	}

	public static Page<ItemDto> toDtoList(Page<Item> listItem) {
		
		List<ItemDto> listItemDto = new ArrayList<ItemDto>();
		
		for (Item item : listItem) {
			listItemDto.add(new ItemDto(item.getId(), item.getTitle(), item.getDescription()));
		}
		
		return new PageImpl<ItemDto>(listItemDto, listItem.getPageable(), listItem.getTotalElements());
	}
    
}
