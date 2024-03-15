package com.SpringJpa.Service;

import java.util.List;


import com.SpringJpa.Entity.User;

public interface CreateUser {
	
	public void Createuser(User user);
	
	public User getByIdUser(String email);
	
	public List<User> listOfUsers();
	
	public String updateUser(User user);
	
	public String deleteUser(String id);
}
