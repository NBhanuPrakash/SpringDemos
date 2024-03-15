package com.NNTechie.QuizApp.Service;

import com.NNTechie.QuizApp.DTO.RequestAuthScore;
import com.NNTechie.QuizApp.DTO.ResponseAuthScore;

public interface QuizAppUserScoreService {
	
	public ResponseAuthScore getById(int id);
	
	public String updateScore(RequestAuthScore requestAuthScore);
	
	public String deleteData(int id);

}
