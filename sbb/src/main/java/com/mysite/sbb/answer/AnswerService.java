package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

@Service
public class AnswerService {
	
	@Autowired
    private AnswerRepository answerRepository;
	
	public Answer create(Question question, String content, SiteUser user) {
		Answer a = new Answer();
		a.setContent(content);
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(question);
		a.setAuthor(user);
		a = this.answerRepository.save(a);
		return a;
    }
}