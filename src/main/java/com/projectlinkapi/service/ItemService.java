package com.projectlinkapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projectlinkapi.model.Item;
import com.projectlinkapi.model.User;
import com.projectlinkapi.web.dto.ItemDto;
import com.projectlinkapi.web.form.ItemForm;

public interface  ItemService {

	Page<Item> findAll(Pageable pagination);
	ItemDto findById(Long id);
	Item save(ItemForm itemForm, User user);
	ItemDto update(Item item);
	void delete(Long id);
	List<Item> findAllByUSerId(Long idUser);
}
