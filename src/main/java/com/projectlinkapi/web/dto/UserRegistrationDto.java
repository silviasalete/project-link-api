package com.projectlinkapi.web.dto;

import java.util.Collection;
import java.util.Collections;

import com.projectlinkapi.model.Role;
import com.projectlinkapi.model.User;

public class UserRegistrationDto {

    private String name;
    private String email;
    private String password;
    private String dominio;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String name, String email, String password, String dominio) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.dominio = dominio;
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
		return new User(userRegistrationDto.getName(),userRegistrationDto.getEmail(),userRegistrationDto.getPassword(), userRegistrationDto.getDominio(), Collections.singletonList(new Role("ROLE_USER")));
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [name=" + name + ", email=" + email + ", password=" + password + ", dominio="
				+ dominio + "]";
	}
	
}