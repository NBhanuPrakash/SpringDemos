package com.NNTechie.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NNTechie.Security.Dto.AuthRequest;
import com.NNTechie.Security.Entity.User;
import com.NNTechie.Security.Service.JWTService;
import com.NNTechie.Security.Service.UserService;

@RestController
@RequestMapping("/security/sec")
public class SecurityController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	public String welcomePage() {
		return "<h1>Welcome<h1/>";
	}
	
	@PostMapping
	public String saveData(@RequestBody User user) {
		return userService.saveData(user);	
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String adminpage() {
		return "<h1>Hello Admin<h1/>";
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/user")
	public String userpage() {
		return "<h1>Hello User<h1/>";
	}
	
	
	@PostMapping("/authentication")
	public String genrateToken(@RequestBody AuthRequest authrequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getEmail(), authrequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtService.genrateToken(authrequest.getEmail());
		}else {
			throw new UsernameNotFoundException("Invalid User");
		}
		
	}
	
	
	

}
