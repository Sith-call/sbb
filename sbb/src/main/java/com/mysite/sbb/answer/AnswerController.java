package com.mysite.sbb.answer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
    private AnswerService answerService;
		
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
		Optional<Question> question = this.questionService.getQuestion(id);
		if (question.isPresent()) {
			this.answerService.create(question.get(), content);
			return String.format("redirect:/question/detail/%s", id);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}
	}
}