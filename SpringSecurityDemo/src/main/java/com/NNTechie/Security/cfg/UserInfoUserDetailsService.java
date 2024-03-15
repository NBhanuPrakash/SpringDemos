package com.NNTechie.Security.cfg;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.NNTechie.Security.Entity.User;
import com.NNTechie.Security.Repo.UserInfoRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> findByEmail = userInfoRepo.findByEmail(username);
		return findByEmail.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found "+username));
		
		
	}

	
	

}
