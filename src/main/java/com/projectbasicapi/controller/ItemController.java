package com.projectbasicapi.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projectbasicapi.model.Item;
import com.projectbasicapi.model.User;
import com.projectbasicapi.service.ItemService;
import com.projectbasicapi.service.UserService;
import com.projectbasicapi.web.dto.ItemDto;
import com.projectbasicapi.web.form.ItemForm;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;

	@GetMapping
	@Cacheable(value = "ListItem")
	public Page<Item> findAll(Pageable pagination) {		
//		http://localhost:8080/item?page=0&size=3&sort=id,desc&sort=title,asc
		return itemService.findAll(pagination);
	}

	@GetMapping("/all/{idUser}")
	public List<Item> findAllById(@PathVariable Long idUser) {		
		return itemService.findAllByUSerId(idUser);
	}
	
	@GetMapping("/{id}")
	public ItemDto findById(@PathVariable Long id) {
		return itemService.findById(id);
	}
	
	@PostMapping("/save")
	@Transactional
	@CacheEvict(value = "ListItem", allEntries = true)
	public ResponseEntity<ItemDto> save(@RequestBody @Valid ItemForm itemForm,  UriComponentsBuilder uriBuilder) {
		
		Item item = itemService.save(itemForm, userService.findById(itemForm.getIdUser()));
		
		URI uri = uriBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).body(ItemDto.toDto(item));
	}
	
	@PutMapping("/update")
	@Transactional
	@CacheEvict(value = "ListItem", allEntries = true)
	public ResponseEntity<ItemDto> update(@RequestBody @Valid Item item) {
		return ResponseEntity.ok(itemService.update(item)) ;
	}
	 
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "ListItem", allEntries = true)
	public ResponseEntity<?> delet(@PathVariable Long id) {
		itemService.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}
