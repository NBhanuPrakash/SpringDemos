package com.NNTechie.QuizApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NNTechie.QuizApp.DTO.RequestAuth;
import com.NNTechie.QuizApp.Service.QuizAppService;

@RestController
@RequestMapping("/add/user")
@CrossOrigin
public class QuizAppController {
	
	
	@Autowired
	private QuizAppService quizAppService;
	
	
	@PostMapping
	public String addUser(@RequestBody RequestAuth requestAuth) {
		return quizAppService.addUser(requestAuth);
	}

}
