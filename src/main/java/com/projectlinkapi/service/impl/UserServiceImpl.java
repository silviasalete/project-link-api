package com.projectlinkapi.service.impl;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectlinkapi.model.User;
import com.projectlinkapi.repository.UserRepository;
import com.projectlinkapi.service.UserService;
import com.projectlinkapi.utils.ReplaceSpecialCharacters;
import com.projectlinkapi.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		
		String passwordCrypt = new BCryptPasswordEncoder().encode(userRegistrationDto.getPassword());
		userRegistrationDto.setPassword(passwordCrypt);
		
		ReplaceSpecialCharacters domainFormated = new ReplaceSpecialCharacters();
		userRegistrationDto.setDomain(domainFormated.replaceAll(userRegistrationDto.getDomain()));
		
		return userRepository.save(userRegistrationDto.toEntity(userRegistrationDto));
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public Optional<User> haveDomain(String domain) {	
		return userRepository.findByDomain(domain);
	}
	
}
