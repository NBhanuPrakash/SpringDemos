package com.NNTechie.QuizApp.DTO;


import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestQuestions {
	
	private String questionId;

	private String questionName;
	
	@Autowired
	private RequestOptions options;
	
	private String answer;
}
