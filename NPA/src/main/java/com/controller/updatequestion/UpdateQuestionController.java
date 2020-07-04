package com.controller.updatequestion;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.updatequestion.UpdateQuestionDetails;
import com.entity.updatequestion.UpdateQuestionResponse;
import com.service.updatequestion.UpdateQuestionService;

import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600)
@RestController
public class UpdateQuestionController {
	
	@Autowired
	UpdateQuestionService updateQuestionService;

	@RequestMapping(value="/updatequestion",method=RequestMethod.PUT)
	@ResponseBody
	public UpdateQuestionResponse doUpdate(@RequestBody UpdateQuestionDetails uqd) throws ParseException{
		 
		UpdateQuestionResponse updateQuestionResponse =new UpdateQuestionResponse();
		
		if(!updateQuestionService.updateQuestions(uqd)) {
			updateQuestionResponse.setErrorMessage("Update Failed");
			updateQuestionResponse.setStatus("false");	
		}
		else
		{
			updateQuestionResponse.setSuccessMessage("Update Success");
			updateQuestionResponse.setStatus("true");
		}
		return updateQuestionResponse;
	}
	
}
