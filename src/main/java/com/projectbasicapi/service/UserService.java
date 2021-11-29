package com.projectbasicapi.service;

import com.projectbasicapi.model.User;
import com.projectbasicapi.web.dto.UserRegistrationDto;

public interface UserService {

	User save(UserRegistrationDto userRegistrationDto);
	User findById(Long id);
	
}
