package com.projectbasicapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectbasicapi.model.User;
import com.projectbasicapi.repository.UserRepository;
import com.projectbasicapi.service.UserService;
import com.projectbasicapi.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		String passwordCrypt = new BCryptPasswordEncoder().encode(userRegistrationDto.getPassword());
		userRegistrationDto.setPassword(passwordCrypt);
		return userRepository.save(userRegistrationDto.toEntity(userRegistrationDto));
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
}
