package com.projectlinkapi.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.projectlinkapi.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${home.jwt.secret}")
	private String secret;
	
	@Value("${home.jwt.expiration}")
	private String expiration;

	public String getToken(Authentication authenticate) {
		User logged = (User) authenticate.getPrincipal();
		Date today = new Date();
		Date dateExpiration = new Date(today.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setExpiration(dateExpiration)
				.claim("id", logged.getId())
				.claim("name", logged.getName())
				.claim("email", logged.getEmail())
				.claim("roles", logged.getRoles())
				.setIssuer("API Home Office")
				.setSubject(logged.getId().toString())
				.setIssuedAt(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValid(String token) {
		try {
	        Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
	        return true;
	    }catch(Exception e) {
	        return false;
	    }
	}

	public Long getIdUSer(String token) {
		 Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		 return Long.parseLong(claims.getSubject());
	}

}
