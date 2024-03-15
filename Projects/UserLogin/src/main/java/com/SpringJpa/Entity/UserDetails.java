package com.SpringJpa.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
	private String userName;
	
	private String phoneNumber;
	
	private String dateOfBirth;
}
