package com.controller.questionlist.user;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.questionlist.user.UserQuestionDetails;
import com.service.questionlist.user.UserQuestionService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600) 
@RestController
public class UserQuestionController {
	
	@Autowired
	UserQuestionService userQuestionService;
	
	@RequestMapping(value="/getUserQuestions/{qnum}",method=RequestMethod.GET)
	
	public UserQuestionDetails getUserQuestions(@PathVariable(value = "qnum")  String qnum)throws ParseException{
		UserQuestionDetails det=userQuestionService.getQuestionsByQnum(qnum);
		return det;
		}
}
