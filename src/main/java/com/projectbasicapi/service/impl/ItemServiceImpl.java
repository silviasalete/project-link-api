package com.projectbasicapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectbasicapi.model.Item;
import com.projectbasicapi.model.User;
import com.projectbasicapi.repository.ItemRepository;
import com.projectbasicapi.repository.UserRepository;
import com.projectbasicapi.service.ItemService;
import com.projectbasicapi.web.dto.ItemDto;
import com.projectbasicapi.web.form.ItemForm;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Page<Item> findAll(Pageable pagination) {
		
		 Page<Item>       itemList = itemRepository.findAll(pagination);
		 
		return itemList;
	}

	@Override
	public ItemDto findById(Long id) {
		
		return ItemDto.toDto(itemRepository.findById(id).get());
	}

	@Override
	public Item save(ItemForm itemForm, User user) {
		Item item = itemForm.toEntity();
		item.setCreatedBy(user);
		item.setCreatedIn(new Date());
		item.setUpdatedBy(user);
		item.setUpdatedIn(new Date());
		itemRepository.save(item);
		return item;
	}

	@Override
	public ItemDto update(Item item) {
		
		Item itemFound = itemRepository.findById(item.getId()).get();
		itemFound.setTitle(item.getTitle());
		itemFound.setDescription(item.getDescription());
		ItemDto itemDto = new ItemDto();
		return itemDto.toDto(itemFound);
	}

	@Override
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public List<Item> findAllByUSerId(Long idUser) {  
		User user = userRepository.findById(idUser).get();
		return itemRepository.findAllByCreatedBy(user);
	}
}
