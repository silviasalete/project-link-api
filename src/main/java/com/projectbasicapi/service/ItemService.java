package com.projectbasicapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projectbasicapi.model.Item;
import com.projectbasicapi.model.User;
import com.projectbasicapi.web.dto.ItemDto;
import com.projectbasicapi.web.form.ItemForm;

public interface  ItemService {

	Page<Item> findAll(Pageable pagination);
	ItemDto findById(Long id);
	Item save(ItemForm itemForm, User user);
	ItemDto update(Item item);
	void delete(Long id);
	List<Item> findAllByUSerId(Long idUser);
}
