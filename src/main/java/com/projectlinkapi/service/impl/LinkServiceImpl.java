package com.projectlinkapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectlinkapi.model.Link;
import com.projectlinkapi.model.User;
import com.projectlinkapi.repository.LinkRepository;
import com.projectlinkapi.repository.UserRepository;
import com.projectlinkapi.service.LinkService;
import com.projectlinkapi.web.dto.LinkDto;
import com.projectlinkapi.web.form.LinkForm;

@Service
public class LinkServiceImpl implements LinkService {
	
	@Autowired
	LinkRepository linkRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Page<Link> findAll(Pageable pagination) {
		
		 Page<Link>       linkList = linkRepository.findAll(pagination);
		 
		return linkList;
	}

	@Override
	public LinkDto findById(Long id) {
		
		return LinkDto.toDto(linkRepository.findById(id).get());
	}

	@Override
	public Link save(LinkForm linkForm, User user) {
		Link link = linkForm.toEntity();
		link.setCreatedBy(user);
		link.setCreatedIn(new Date());
		link.setUpdatedBy(user);
		link.setUpdatedIn(new Date());
		linkRepository.save(link);
		return link;
	}

	@Override
	public LinkDto update(Link link) {
		
		Link linkFound = linkRepository.findById(link.getId()).get();
		linkFound.setTitle(link.getTitle());
		linkFound.setUrl(link.getUrl());
		LinkDto linkDto = new LinkDto();
		return linkDto.toDto(linkFound);
	}

	@Override
	public void delete(Long id) {
		linkRepository.deleteById(id);
	}

	@Override
	public List<Link> findAllByUSerId(Long idUser) {  
		User user = userRepository.findById(idUser).get();
		return linkRepository.findAllByCreatedBy(user);
	}
}
