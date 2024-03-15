package com.SpringJpa.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String addressType;
	
	private String doorNo;
	
	private String landMark;
	
	private String cityName;
	
	private String stateName;
	
	private int pincode;
	
	

}
