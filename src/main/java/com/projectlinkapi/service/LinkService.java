package com.projectlinkapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projectlinkapi.model.Link;
import com.projectlinkapi.model.User;
import com.projectlinkapi.web.dto.LinkDto;
import com.projectlinkapi.web.form.LinkForm;

public interface  LinkService {

	Page<Link> findAll(Pageable pagination);
	LinkDto findById(Long id);
	Link save(LinkForm linkForm, User user);
	LinkDto update(Link link);
	void delete(Long id);
	List<Link> findAllByUSerId(Long idUser);
}
