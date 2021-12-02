package com.projectlinkapi.service;

import com.projectlinkapi.model.User;
import com.projectlinkapi.web.dto.UserRegistrationDto;

public interface UserService {

	User save(UserRegistrationDto userRegistrationDto);
	User findById(Long id);
	
}
