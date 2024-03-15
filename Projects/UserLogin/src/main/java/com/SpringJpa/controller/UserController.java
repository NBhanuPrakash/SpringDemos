package com.SpringJpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Dto.UserDto;
import com.SpringJpa.Dto.UserLoginDto;
import com.SpringJpa.Entity.User;
import com.SpringJpa.Mappers.DtoTOEntitys;
import com.SpringJpa.Service.CreateUser;

@RestController
@CrossOrigin
@RequestMapping("/userlogin")
public class UserController {

	@Autowired
	CreateUser createUser;

	@PostMapping("/createUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
		User dtotoEntity = DtoTOEntitys.dtotoEntity(userDto);
		createUser.Createuser(dtotoEntity);
		return ResponseEntity.ok("user Created..");
	}

	@GetMapping("/id/{email}")
	public UserDto getById(@PathVariable String email) {
		User byIdUser = createUser.getByIdUser(email);
		UserDto entityToDto = DtoTOEntitys.entityToDto(byIdUser);
		return entityToDto;
	}
	
	@GetMapping("/login")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDto getByUserLogin(@RequestBody UserLoginDto userLoginDto) {
		User byIdUser = createUser.getByIdUser(userLoginDto.getEmail());
		if (byIdUser.getPassword().equals(userLoginDto.getPassword())) {
			UserDto entityToDto = DtoTOEntitys.entityToDto(byIdUser);
			return entityToDto;
		}
		return null;
	}

}
