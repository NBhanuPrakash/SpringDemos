package com.SpringJpa.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private String addressType;
	
	private String doorNo;

	private String landMark;

	private String cityName;

	private String stateName;

	private int pincode;
}
