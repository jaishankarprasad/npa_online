package com.controller.addquestion;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.addquestion.AddQuestionResponse;
import com.entity.addquestion.QuestionDetails;
import com.service.addquestion.AddQuestionService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600) 
@RestController
public class AddQuestionController {
	
	@Autowired
	AddQuestionService addQuestionService;
	
	@RequestMapping(value="/addQuestion",method=RequestMethod.POST)
	@ResponseBody
	public AddQuestionResponse addQuestion(@RequestBody QuestionDetails questionDetails) throws ParseException{
		
		AddQuestionResponse aqResponse=new AddQuestionResponse();
		if(!addQuestionService.addQuestion(questionDetails)) {
			aqResponse.setErrorMessage("cant add question");
			aqResponse.setStatus("FALSE");	
		}
		else {
			aqResponse.setSuccessMessage("question added");
			aqResponse.setStatus("TRUE");
		}
		return aqResponse;
	}

}
