package com.NNTechie.QuizApp.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.NNTechie.QuizApp.Builder.QuizUserModelMapper;
import com.NNTechie.QuizApp.DTO.RequestAuthScore;
import com.NNTechie.QuizApp.DTO.ResponseAuthScore;
import com.NNTechie.QuizApp.Entity.QuizData;
import com.NNTechie.QuizApp.Repo.QuizAppUserRepo;
import com.NNTechie.QuizApp.Service.QuizAppUserScoreService;

@Service
public class QuizAppUserScoreServiceImpl implements QuizAppUserScoreService {
	
	@Autowired
	private QuizAppUserRepo quizAppUserRepo;
	
	@Autowired
	private QuizUserModelMapper quizUsermidelMapper;

	@Override
	public ResponseAuthScore getById(int id) {
		QuizData quizData = quizAppUserRepo.findById(id).get();
		ResponseAuthScore entityToResponseAuthScore = quizUsermidelMapper.entityToResponseAuthScore(quizData);
		return entityToResponseAuthScore;
	}

	@Override
	public String updateScore(RequestAuthScore requestAuthScore) {
		QuizData quizData = quizAppUserRepo.findById(requestAuthScore.getId()).get();
		if (quizData!=null) {
			quizData.setUserScore(requestAuthScore.getUserScore());
			quizAppUserRepo.save(quizData);
			return "Updated";
		}else {
			throw new UsernameNotFoundException("User not Found");
		}
	}

	@Override
	public String deleteData(int id) {
		Optional<QuizData> findById = quizAppUserRepo.findById(id);
		if (findById.isPresent()) {
			quizAppUserRepo.deleteById(id);
			return "Updated";
		}else {
			throw new UsernameNotFoundException("User not Found");
		}
	}

}
