package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${app.jwt.secret}")

	private String jwtSecret;

	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;

		} catch (ExpiredJwtException e) {
			// TODO: handle exception
			LOG.error("Token expirado {}",e.getMessage());
		}
		catch(io.jsonwebtoken.SignatureException e) {
			LOG.error("Token invalido{}",e.getMessage());
		}
		return false;
	}
	
	public String  getUsernameFromJwtToken(String token) {
		//se obtiene el nombre a partir del tokn
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		
		
	}
	
	
	

}
