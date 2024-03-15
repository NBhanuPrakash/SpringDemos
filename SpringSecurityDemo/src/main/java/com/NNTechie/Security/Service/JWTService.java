package com.NNTechie.Security.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {

	public String genrateToken(String email) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, email);
	}

	private String createToken(Map<String, Object> claims, String email) {

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(getSecKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getSecKey() {
		byte[] decode = Decoders.BASE64.decode("3273357638792F423F45284228545B4526335658565D595554127896F754126D85413");
		return Keys.hmacShaKeyFor(decode);
	}

	public String extractUserName(String token) {
		
		return extractClaim(token,Claims::getSubject);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSecKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public Boolean ValidToken(String token, UserDetails userName) {
		final String extractUserName = extractUserName(token);
		System.out.println("UserName "+extractUserName);
//		boolean flag = extractUserName.equals(userName.getName()) && !isTokenExpired(token);
		return (extractUserName.equals(userName.getUsername()) && !isTokenExpired(token));
		
		
	}

	private Boolean isTokenExpired(String token) {
		return extraExpiration(token).before(new Date());
	}
	
	public Date extraExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	
	
	

}
