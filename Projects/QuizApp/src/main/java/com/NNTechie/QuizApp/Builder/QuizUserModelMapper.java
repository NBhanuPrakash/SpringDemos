package com.NNTechie.QuizApp.Builder;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.NNTechie.QuizApp.DTO.RequestAuth;
import com.NNTechie.QuizApp.DTO.ResponseAuth;
import com.NNTechie.QuizApp.DTO.ResponseAuthScore;
import com.NNTechie.QuizApp.Entity.QuizAppUser;
import com.NNTechie.QuizApp.Entity.QuizData;

@Mapper(componentModel = "spring")
public interface QuizUserModelMapper {
	
	QuizUserModelMapper INSTANCE = Mappers.getMapper(QuizUserModelMapper.class);

	@Mapping(source = "requestAuth.requestAuthScore", target = "quizData")
	@Mapping(source = "requestAuth.role", target = "userRole")
	public QuizAppUser dtoToEntity(RequestAuth requestAuth);

    
    public List<ResponseAuth> entityToDto(List<QuizAppUser> quizAppUsers);
    
    
    @Mapping(source = "quizAppUser.userRole",target = "role")
    @Mapping(source = "quizAppUser.quizData", target = "responseAuthScore")
    public ResponseAuth responseAuth(QuizAppUser quizAppUser);
    
    public ResponseAuthScore entityToResponseAuthScore(QuizData quizData);
    
    

}