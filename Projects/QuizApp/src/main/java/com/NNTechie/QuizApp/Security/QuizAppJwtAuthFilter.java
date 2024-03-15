package com.NNTechie.QuizApp.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class QuizAppJwtAuthFilter extends OncePerRequestFilter {
	
	@Autowired
	private QuizAppJWTService quizAppJWTService;
	
	@Autowired
	private UserInfoUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		if (header!=null && header.startsWith("Bearer")) {
			token = header.substring(7);
			userName = quizAppJWTService.extractUserName(token);
		}
		if (userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(userName);
			if (quizAppJWTService.validToken(token, loadUserByUsername)) {
				UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(loadUserByUsername, null,loadUserByUsername.getAuthorities());
				usernameToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernameToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
	

}