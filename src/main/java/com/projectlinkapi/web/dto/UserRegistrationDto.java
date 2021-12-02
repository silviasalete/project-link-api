package com.projectlinkapi.web.dto;

import java.util.Collections;

import com.projectlinkapi.model.Role;
import com.projectlinkapi.model.User;

public class UserRegistrationDto {

    private String name;
    private String email;
    private String password;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public User toEntity(UserRegistrationDto userRegistrationDto) {
		return new User(userRegistrationDto.getName(),userRegistrationDto.getEmail(),userRegistrationDto.getPassword(),Collections.singletonList(new Role("ROLE_USER")));
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}