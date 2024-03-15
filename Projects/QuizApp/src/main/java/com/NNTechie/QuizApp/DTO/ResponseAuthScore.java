package com.NNTechie.QuizApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAuthScore {
	
	private int id;

	private String userScore;
	
	private String loginTime;
	
	private String logoutTime;

}
