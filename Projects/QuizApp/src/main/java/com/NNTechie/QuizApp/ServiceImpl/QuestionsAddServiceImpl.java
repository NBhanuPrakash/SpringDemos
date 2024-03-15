package com.NNTechie.QuizApp.ServiceImpl;

import java.util.List;
import java.util.UUID;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.NNTechie.QuizApp.Builder.QuizQuestionModelMapper;
import com.NNTechie.QuizApp.DTO.RequestQuestions;
import com.NNTechie.QuizApp.DTO.ResponseQues;
import com.NNTechie.QuizApp.Entity.Options;
import com.NNTechie.QuizApp.Entity.QuizQuestions;
import com.NNTechie.QuizApp.Repo.QuizQuestionsRepo;
import com.NNTechie.QuizApp.Service.QuestionsAdd;

@Service
public class QuestionsAddServiceImpl implements QuestionsAdd {
	
	private static final Logger log = LoggerFactory.getLogger(QuestionsAddServiceImpl.class);

	
	@Autowired
	private QuizQuestionsRepo quizQuestions;
	
	@Autowired
	private QuizQuestionModelMapper quizQuestionModelMapper;

	@Override
	public String addQuestion(RequestQuestions requestQuestions) {
		QuizQuestions entity = quizQuestionModelMapper.dtoToEntityQuestions(requestQuestions);
		entity.setId(UUID.randomUUID().toString().split("-")[0]);
		quizQuestions.save(entity);
		return "Saved";
	}

	@Override
	public List<ResponseQues> getAllQuestions() {
		List<QuizQuestions> findAll = quizQuestions.findAll();
		List<ResponseQues> entityToDtoQues = quizQuestionModelMapper.entityToDtoQuesList(findAll);
		return entityToDtoQues;
	}

	@Override
	public ResponseQues getByIdQuestion(String id) {
	    Optional<QuizQuestions> optionalQuizQuestions = quizQuestions.findById(id);

	    if (optionalQuizQuestions.isPresent()) {
	        QuizQuestions quizQuestions2 = optionalQuizQuestions.get();
	        ResponseQues entityToDtoQues = quizQuestionModelMapper.entityToDtoQues(quizQuestions2);
	        return entityToDtoQues;
	    } else {
	        throw new UsernameNotFoundException("Question Not Found...");
	    }
	}


	@Override
	public String deleteQuestion(String id) {
		QuizQuestions quizQuestions2 = quizQuestions.findById(id).get();
		if (quizQuestions2!=null) {
			quizQuestions.deleteById(id);
			return "Deleted Question";
		}else {
			throw new UsernameNotFoundException("Question Not Found...");
		}
		
	}

	@Override
	public String updateQuestion(RequestQuestions requestQuestions) {
		Optional<QuizQuestions> optionalQuizQuestions = quizQuestions.findById(requestQuestions.getQuestionId());

	    if (optionalQuizQuestions.isPresent()) {
	        QuizQuestions quizQuestions2 = optionalQuizQuestions.get();
	        if (quizQuestions2!=null) {
	        	 Options options = new Options();
	             options.setOption1(requestQuestions.getOptions().getOption1());
	             options.setOption2(requestQuestions.getOptions().getOption2());
	             options.setOption3(requestQuestions.getOptions().getOption3());
	             options.setOption4(requestQuestions.getOptions().getOption4());
	             
	             quizQuestions2.setOptions(options);
	             quizQuestions2.setAnswer(requestQuestions.getAnswer());
	             quizQuestions.save(quizQuestions2);
	             return "Upadted";
			}else {
				throw new UsernameNotFoundException("Question Not Found");
			}
	        
	    } else {
	        throw new UsernameNotFoundException("Question Not Found...");
	    }
	}

	

}
