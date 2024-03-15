package com.NNTechie.QuizApp.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.NNTechie.QuizApp.Entity.QuizQuestions;

@Repository
public interface QuizQuestionsRepo extends MongoRepository<QuizQuestions, String> {
	

}
