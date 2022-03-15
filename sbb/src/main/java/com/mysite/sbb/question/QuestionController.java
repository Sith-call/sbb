package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {
	
	@Autowired
    private QuestionService questionService;

	@RequestMapping("/question/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
		return "question_list";
	}
}