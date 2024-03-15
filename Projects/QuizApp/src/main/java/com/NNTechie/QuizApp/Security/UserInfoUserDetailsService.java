package com.NNTechie.QuizApp.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.NNTechie.QuizApp.Entity.QuizAppUser;
import com.NNTechie.QuizApp.Repo.QuizAppRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private QuizAppRepo quizAppRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<QuizAppUser> findById = quizAppRepo.findById(username);
		return findById.map(UserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("User Not Found.."+username));
	}
	
	
}
