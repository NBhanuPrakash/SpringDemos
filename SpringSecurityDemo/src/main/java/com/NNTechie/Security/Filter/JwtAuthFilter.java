package com.NNTechie.Security.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.NNTechie.Security.Service.JWTService;
import com.NNTechie.Security.cfg.UserInfoUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private UserInfoUserDetailsService userInfoUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		if (header!= null && header.startsWith("Bearer ")) {
			token = header.substring(7);
			userName = jwtService.extractUserName(token);
		}
		if (userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails loadUserByUsername = userInfoUserDetailsService.loadUserByUsername(userName);
			if (jwtService.ValidToken(token, loadUserByUsername)) {
				UsernamePasswordAuthenticationToken userNameToken = new UsernamePasswordAuthenticationToken(loadUserByUsername, null,loadUserByUsername.getAuthorities());
				userNameToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNameToken);
			} 
		}
		filterChain.doFilter(request, response);
	}

}
