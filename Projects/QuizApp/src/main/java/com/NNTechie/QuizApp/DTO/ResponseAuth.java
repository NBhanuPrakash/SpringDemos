package com.NNTechie.QuizApp.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAuth {

	private String userName;

	private String userEmail;

	private String userPassword;

	private String phNumber;

	private String role;

	@Autowired
	private ResponseAuthScore responseAuthScore;

}
