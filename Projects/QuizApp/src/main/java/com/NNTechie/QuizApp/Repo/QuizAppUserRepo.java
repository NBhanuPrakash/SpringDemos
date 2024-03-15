package com.NNTechie.QuizApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NNTechie.QuizApp.Entity.QuizData;
@Repository
public interface QuizAppUserRepo extends JpaRepository<QuizData, Integer> {

}
