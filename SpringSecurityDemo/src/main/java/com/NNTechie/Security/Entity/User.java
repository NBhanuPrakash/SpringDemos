package com.NNTechie.Security.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Info")
public class User {
	
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String role;

}
