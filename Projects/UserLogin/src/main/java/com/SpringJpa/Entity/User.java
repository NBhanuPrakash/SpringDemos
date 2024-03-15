package com.SpringJpa.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("UserLogin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private String email;
	
	private String password;
	
	private String userName;
	
	

}
