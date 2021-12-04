package com.projectlinkapi.web.dto;

import java.util.Collection;
import java.util.Collections;

import com.projectlinkapi.model.Role;
import com.projectlinkapi.model.User;

public class UserRegistrationDto {

    private String name;
    private String email;
    private String password;
    private String domain;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String name, String email, String password, String domain) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.domain = domain;
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
		return new User(userRegistrationDto.getName(),userRegistrationDto.getEmail(),userRegistrationDto.getPassword(), userRegistrationDto.getDomain(), Collections.singletonList(new Role("ROLE_USER")));
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [name=" + name + ", email=" + email + ", password=" + password + ", domain="
				+ domain + "]";
	}
	
}