package com.projectbasicapi.web.dto;

import java.util.Collection;

import com.projectbasicapi.model.Role;
import com.projectbasicapi.model.User;

public class UserDto {

    private String name;
    private String email;
    private String password;
    private Collection<Role> roles;
    
	public UserDto() {
		super();
	}
	
	public UserDto(String name, String email, String password, Collection<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
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
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public User toEntity(UserDto userDto) {
		return new User(userDto.getName(),userDto.getEmail(),userDto.getPassword(),userDto.getRoles());
	}
    
    
}
