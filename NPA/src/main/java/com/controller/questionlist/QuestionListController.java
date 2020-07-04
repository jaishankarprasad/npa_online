package com.controller.questionlist;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.questionlist.QuestionListDetails;
import com.service.questionlist.QuestionListService;

@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600) 
@RestController
public class QuestionListController {
	@Autowired(required=true)
	QuestionListService questionListService;
	
	@RequestMapping(value="/viewQuestionbyTestname/{testname}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<QuestionListDetails> getQuestionbyTestname(@PathVariable(value = "testname")String testname)throws ParseException{
		List<QuestionListDetails> ql=questionListService.getQuestionbyTestname(testname);
		return ql;
	}
}
