package com.NNTechie.QuizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NNTechie.QuizApp.DTO.RequestAuth;
import com.NNTechie.QuizApp.DTO.RequestQuestions;
import com.NNTechie.QuizApp.DTO.ResponseAuth;
import com.NNTechie.QuizApp.DTO.ResponseQues;
import com.NNTechie.QuizApp.ServiceImpl.QuestionsAddServiceImpl;
import com.NNTechie.QuizApp.ServiceImpl.QuizAppServiceImpl;

@RestController
@RequestMapping("/admin/access")
public class QuizAppAdmin {
	


	@Autowired
	private QuestionsAddServiceImpl questionsAddServiceImpl;
	
	@Autowired
	private QuizAppServiceImpl quizAppServiceImpl;

	@PostMapping("add/questions")
	public String addQuestions(@RequestBody RequestQuestions requestQuestions) {
		return questionsAddServiceImpl.addQuestion(requestQuestions);
	}
	
	
	@PostMapping("add/user")
	public String addUser(@RequestBody RequestAuth requestAuth) {
		return quizAppServiceImpl.addUser(requestAuth);
	}
	
	@GetMapping("/getallUsers")
	public List<ResponseAuth> getallUsers(){
		
		return quizAppServiceImpl.getall();
	}
	
	@GetMapping("/getallQues")
	public List<ResponseQues> getAllQuestionsList(){
		return questionsAddServiceImpl.getAllQuestions();
	}
	
	@GetMapping("/get/Question/{id}")
	public ResponseQues getQuestion(@PathVariable String id) {
		return questionsAddServiceImpl.getByIdQuestion(id);
	}
	
	@PutMapping("/update/questions")
	public String updateQuestion(@RequestBody RequestQuestions requestQuestions) {
		return questionsAddServiceImpl.updateQuestion(requestQuestions);
	}
	
	
	@DeleteMapping("/delete/Question/{id}")
	public String deleteQues(@PathVariable String id) {
		return questionsAddServiceImpl.deleteQuestion(id);
	}
	
	

}
