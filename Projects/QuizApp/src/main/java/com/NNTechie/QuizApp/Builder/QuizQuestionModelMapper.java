package com.NNTechie.QuizApp.Builder;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.NNTechie.QuizApp.DTO.RequestQuestions;
import com.NNTechie.QuizApp.DTO.ResponseQues;
import com.NNTechie.QuizApp.Entity.QuizQuestions;

@Mapper(componentModel = "spring")
public interface QuizQuestionModelMapper {
	
	QuizQuestionModelMapper INSTANCE = Mappers.getMapper(QuizQuestionModelMapper.class);

	
	@Mapping(source="requestQuestions.options",target = "options")
	public QuizQuestions dtoToEntityQuestions(RequestQuestions requestQuestions);

	public List<ResponseQues> entityToDtoQuesList(List<QuizQuestions> quizQuestions);
	
	@Mapping(source = "quizQuestions.options", target = "options")
    @Mapping(source = "quizQuestions.id", target = "questionId")
    public ResponseQues entityToDtoQues(QuizQuestions quizQuestions);
}
