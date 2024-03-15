package com.SpringJpa.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringJpa.Entity.User;
import com.SpringJpa.Repo.UserLoginRepo;
import com.SpringJpa.Service.CreateUser;

@Service
public class CreateUserImpl implements CreateUser {
	
	@Autowired
	UserLoginRepo userLoginRepo;

	@Override
	public void Createuser(User user) {
		userLoginRepo.save(user);
	}

	@Override
	public User getByIdUser(String email) {
		User findById = userLoginRepo.findById(email).get();
		return findById;
	}

	@Override
	public List<User> listOfUsers() {
		List<User> findAll = userLoginRepo.findAll();
		return findAll;
	}

	@Override
	public String updateUser(User user) {
		User user2 = userLoginRepo.findById(user.getEmail()).get();
		if (user2!=null) {
			userLoginRepo.save(user2);
		}
		return "Upadted";
	}

	@Override
	public String deleteUser(String id) {
		userLoginRepo.deleteById(id);
		return "Deleted";
	}

}
