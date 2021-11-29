package com.projectbasicapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectbasicapi.model.User;
import com.projectbasicapi.service.UserService;
import com.projectbasicapi.web.dto.UserRegistrationDto;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public User save(@RequestBody UserRegistrationDto userRegistrationDto) {
		return userService.save(userRegistrationDto);
	}
}
