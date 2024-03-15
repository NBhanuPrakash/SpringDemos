package com.NNTechie.QuizApp.Service;


import java.util.List;

import com.NNTechie.QuizApp.DTO.RequestAuth;
import com.NNTechie.QuizApp.DTO.ResponseAuth;

public interface QuizAppService {
	
	public String addUser(RequestAuth requestAuth);
	
	public List<ResponseAuth> getall();

}
