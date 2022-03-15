package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	@Autowired
    private QuestionRepository questionRepository;
	
	public List<Question> getList() {
		List<Question> questionList = this.questionRepository.findAll();
		return questionList;
	}
	
	public Optional<Question> getQuestion(Integer id) {  
        return this.questionRepository.findById(id);  
    }
}