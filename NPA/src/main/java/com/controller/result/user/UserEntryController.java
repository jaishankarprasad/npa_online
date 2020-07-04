package com.controller.result.user;

import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.result.user.Attempted;
import com.entity.result.user.ResultResponse;
import com.service.result.user.UserEntryService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600) 
@RestController
public class UserEntryController {
	
	@Autowired
	UserEntryService userEntryService;
	
	@RequestMapping(value="/insertAttempted",method=RequestMethod.POST)
	public ResultResponse insertResult(@RequestBody Attempted attempted)throws ParseException{

		ResultResponse rResponse=new ResultResponse();
		if(!userEntryService.insertResult(attempted)) {
			rResponse.setErrorMessage("cant add attempted answer");
			rResponse.setStatus("FALSE");	
		}
		else {
			
			rResponse.setSuccessMessage("attempted answer added");
			rResponse.setStatus("TRUE");
		}
		return rResponse;
	}

}
