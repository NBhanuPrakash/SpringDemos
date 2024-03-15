package com.NNTechie.QuizApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NNTechie.QuizApp.Entity.QuizAppUser;

public interface QuizAppRepo extends JpaRepository<QuizAppUser, String> {

}
