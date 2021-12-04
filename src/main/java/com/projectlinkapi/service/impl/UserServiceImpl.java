package com.projectlinkapi.service.impl;

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
		

		ReplaceSpecialCharacters replaceDomain = new ReplaceSpecialCharacters();
		userRegistrationDto.setDomain(replaceDomain.replaceAll(userRegistrationDto.getDomain()));
		
		return userRepository.save(userRegistrationDto.toEntity(userRegistrationDto));
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
}
