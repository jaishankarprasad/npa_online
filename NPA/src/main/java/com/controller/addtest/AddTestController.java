package com.controller.addtest;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.addtest.TestInfo;
import com.entity.addtest.TestResponse;
import com.service.addtest.TestService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600)
@RestController
public class AddTestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value="/addtest",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TestResponse doTest(@RequestBody TestInfo details) throws ParseException{
		TestResponse testResponse=new TestResponse();
		
		System.out.println("Inside doTest method"); 
		if(!testService.addTest(details)) {
			testResponse.setErrorMessage("Couldn't add test");
			testResponse.setStatus("FALSE");
		}
		else {
			testResponse.setSuccessMessage("Test Added");
			testResponse.setStatus("TRUE");
		}
		return testResponse;	
	}
}
