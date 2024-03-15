package com.NNTechie.QuizApp.Service;


import java.util.List;

import com.NNTechie.QuizApp.DTO.RequestQuestions;
import com.NNTechie.QuizApp.DTO.ResponseQues;

public interface QuestionsAdd {
	
	public String addQuestion(RequestQuestions requestQuestions);
	
	public List<ResponseQues> getAllQuestions();
	
	public ResponseQues getByIdQuestion(String id);
	
	public String deleteQuestion(String id);
	
	public String updateQuestion(RequestQuestions requestQuestions);

}
