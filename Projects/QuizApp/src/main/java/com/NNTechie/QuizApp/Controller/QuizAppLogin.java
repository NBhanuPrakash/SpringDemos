package com.NNTechie.QuizApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NNTechie.QuizApp.DTO.RequestLogin;
import com.NNTechie.QuizApp.Security.QuizAppJWTService;

@RestController
@RequestMapping("/login")
public class QuizAppLogin {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private QuizAppJWTService quizAppJWTService;
	
	@PostMapping
	public String genreateToken(@RequestBody RequestLogin login) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
		if (authenticate.isAuthenticated()) {
			return quizAppJWTService.generateToken(login.getUserName());
		}else {
			throw new UsernameNotFoundException("User Not Found...");
		}
	}

}
