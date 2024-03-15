package com.NNTechie.QuizApp.Security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.NNTechie.QuizApp.Entity.QuizAppUser;

public class UserInfoDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String pasword;
	
	private List<GrantedAuthority> roles;
	
	public UserInfoDetails(QuizAppUser user) {
		userName=user.getUserEmail();
		pasword=user.getUserPassword();
		roles=Arrays.stream( user.getUserRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return pasword;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	 

}
