package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.sbb.question.Question;

@Service
public class AnswerService {
	
	@Autowired
    private AnswerRepository answerRepository;
	
	public Answer create(Question question, String content) {
		Answer a = new Answer();
		a.setContent(content);
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(question);
		a = this.answerRepository.save(a);
		return a;
    }
}