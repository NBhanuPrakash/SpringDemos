package com.NNTechie.Security.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.NNTechie.Security.Entity.User;
import com.NNTechie.Security.Repo.UserInfoRepo;


@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	boolean flag;
	
	
	public String saveData(User user) {
		
		List<User> findAll = userInfoRepo.findAll();
		
		if (findAll!=null) {
			for (User user2 : findAll) {
				log.info(user2.getEmail());
				if (user2.getEmail().equals(user.getEmail())) {
					flag=true;
				}
				else {
					flag = false;
				}
			}
		}
		
		if (flag) {
			return "User already Exit's";
		}else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userInfoRepo.save(user);
			log.info("Its Saved"+user);
			return "Saved";
		}	
	}
}
