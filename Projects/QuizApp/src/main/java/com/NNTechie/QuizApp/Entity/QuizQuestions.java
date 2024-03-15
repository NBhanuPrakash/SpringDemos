package com.NNTechie.QuizApp.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "quiz_App")
public class QuizQuestions {
	
	@Id
	private String id;
	
	@Field(name = "question_Name")
	private String questionName;
	
	private Options options;
	
	@Field(name = "answer")
	private String answer;

}
