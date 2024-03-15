package com.NNTechie.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NNTechie.QuizApp.DTO.RequestAuthScore;
import com.NNTechie.QuizApp.DTO.ResponseAuthScore;
import com.NNTechie.QuizApp.DTO.ResponseQues;
import com.NNTechie.QuizApp.ServiceImpl.QuestionsAddServiceImpl;
import com.NNTechie.QuizApp.ServiceImpl.QuizAppUserScoreServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/user/access")
public class QuizAppUser {
	
	@Autowired
	private QuestionsAddServiceImpl questionsAddServiceImpl;
	
	@Autowired
	private QuizAppUserScoreServiceImpl quizAppUserScoreServiceImpl;
	
	@GetMapping("/getall/ques")
	public List<ResponseQues> getAllQues() {
		return questionsAddServiceImpl.getAllQuestions();
	}
	
	@GetMapping("/getScore/user/{id}")
	public ResponseAuthScore getSCore(@PathVariable int id) {
		return quizAppUserScoreServiceImpl.getById(id);
	}
	
	@PutMapping("/updateScore/user")
	public String updateScore(@RequestBody RequestAuthScore requestAuthScore) {
		return quizAppUserScoreServiceImpl.updateScore(requestAuthScore);
	}
	
	
	

}
