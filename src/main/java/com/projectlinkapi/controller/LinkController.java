package com.projectlinkapi.controller;

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

import com.projectlinkapi.model.Link;
import com.projectlinkapi.service.LinkService;
import com.projectlinkapi.service.UserService;
import com.projectlinkapi.web.dto.LinkDto;
import com.projectlinkapi.web.form.LinkForm;

@RestController
@RequestMapping("/link")
@CrossOrigin(origins = "*")
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private UserService userService;

	@GetMapping
	@Cacheable(value = "ListLink")
	public Page<Link> findAll(Pageable pagination) {		
//		http://localhost:8080/link?page=0&size=3&sort=id,desc&sort=title,asc
		return linkService.findAll(pagination);
	}

	@GetMapping("/all/{idUser}")
	public List<Link> findAllById(@PathVariable Long idUser) {		
		return linkService.findAllByUSerId(idUser);
	}
	
	@GetMapping("/{id}")
	public LinkDto findById(@PathVariable Long id) {
		return linkService.findById(id);
	}
	
	@PostMapping("/save")
	@Transactional
	@CacheEvict(value = "ListLink", allEntries = true)
	public ResponseEntity<LinkDto> save(@RequestBody @Valid LinkForm linkForm,  UriComponentsBuilder uriBuilder) {
		
		Link link = linkService.save(linkForm, userService.findById(linkForm.getIdUser()));
		
		URI uri = uriBuilder.path("/link/{id}").buildAndExpand(link.getId()).toUri();
		return ResponseEntity.created(uri).body(LinkDto.toDto(link));
	}
	
	@PutMapping("/update")
	@Transactional
	@CacheEvict(value = "ListLink", allEntries = true)
	public ResponseEntity<LinkDto> update(@RequestBody @Valid Link link) {
		return ResponseEntity.ok(linkService.update(link)) ;
	}
	 
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "ListLink", allEntries = true)
	public ResponseEntity<?> delet(@PathVariable Long id) {
		linkService.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}
