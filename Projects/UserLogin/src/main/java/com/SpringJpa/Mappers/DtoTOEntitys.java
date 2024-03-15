package com.SpringJpa.Mappers;


import com.SpringJpa.Dto.UserDto;
import com.SpringJpa.Entity.User;

public class DtoTOEntitys {
	
	public static User dtotoEntity(UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUserName(userDto.getUserName());
		
		
		return user;
	}
	
	public static UserDto entityToDto(User user) {
		UserDto userdto = new UserDto();
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setUserName(user.getUserName());
		
		return userdto;
	}
 
}
