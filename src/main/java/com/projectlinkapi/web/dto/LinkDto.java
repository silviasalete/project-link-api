package com.projectlinkapi.web.dto;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.projectlinkapi.model.Link;

public class LinkDto {

	private Long id;
    private String title;
    private String description;
	
	public LinkDto() {
		super();
	}

	public LinkDto(Long id, String title, String description) {
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

	public static LinkDto toDto(Link link) {
		
		return new LinkDto(link.getId(), link.getTitle(), link.getDescription());
	}

	public static Page<LinkDto> toDtoList(Page<Link> listLink) {
		
		List<LinkDto> listLinkDto = new ArrayList<LinkDto>();
		
		for (Link link : listLink) {
			listLinkDto.add(new LinkDto(link.getId(), link.getTitle(), link.getDescription()));
		}
		
		return new PageImpl<LinkDto>(listLinkDto, listLink.getPageable(), listLink.getTotalElements());
	}
    
}
