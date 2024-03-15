package com.NNTechie.QuizApp.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Options {
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;

}
