package com.SpringJpa.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

	private String userName;

	private String phoneNumber;

	private String dateOfBirth;
}
