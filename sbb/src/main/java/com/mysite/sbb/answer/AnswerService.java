package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	public Optional<Answer> getAnswer(Integer id) {
        return this.answerRepository.findById(id);
    }

    public Answer modify(Answer a, String content) {
        a.setContent(content);
        a.setModifyDate(LocalDateTime.now());
        a = this.answerRepository.save(a);
        return a;
    }
    
    public void delete(Answer a) {
        this.answerRepository.delete(a);
    }
}