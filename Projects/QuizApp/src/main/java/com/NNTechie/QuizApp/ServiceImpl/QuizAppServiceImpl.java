package com.NNTechie.QuizApp.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.NNTechie.QuizApp.Builder.QuizUserModelMapper;
import com.NNTechie.QuizApp.DTO.RequestAuth;
import com.NNTechie.QuizApp.DTO.ResponseAuth;
import com.NNTechie.QuizApp.Entity.QuizAppUser;
import com.NNTechie.QuizApp.Repo.QuizAppRepo;
import com.NNTechie.QuizApp.Service.QuizAppService;

@Service
public class QuizAppServiceImpl implements QuizAppService {

	@Autowired
	private QuizAppRepo quizAppRepo;
	
	private static final Logger log = LoggerFactory.getLogger(QuestionsAddServiceImpl.class);


	
	@Autowired
	private QuizUserModelMapper quizUserModelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(RequestAuth requestAuth) {
		
		boolean flag = true;
		List<QuizAppUser> findAll = quizAppRepo.findAll();
		if(findAll!=null) {
			for (QuizAppUser quizAppUser : findAll) {
				if (quizAppUser.getUserEmail().equals(requestAuth.getUserEmail())) {
					flag = false;
				}
			}
		}
		if (flag) {
			QuizAppUser dtoToEntity = quizUserModelMapper.dtoToEntity(requestAuth);
			dtoToEntity.setUserPassword(passwordEncoder.encode(dtoToEntity.getUserPassword()));
			quizAppRepo.save(dtoToEntity);
		}else {
			return "User Already Exits";
		}
		return "Saved User";
		
	}

	@Override
	public List<ResponseAuth> getall() {
		List<QuizAppUser> findAll = quizAppRepo.findAll();
		List<ResponseAuth> entityToDto = quizUserModelMapper.entityToDto(findAll);
		return entityToDto;
	}
	
	

}
