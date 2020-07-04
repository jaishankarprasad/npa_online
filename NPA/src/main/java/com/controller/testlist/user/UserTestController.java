package com.controller.testlist.user;

 import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.testlist.user.UserTestDetails;
import com.service.testlist.user.UserTestService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600) 
@RestController
public class UserTestController {
	
	@Autowired
	UserTestService userTestService;

	@RequestMapping(value="/getUserTest",method=RequestMethod.GET)
	@ResponseBody
	public List<UserTestDetails> getTestInfoMapper() throws ParseException{
		List<UserTestDetails> testlist =userTestService.getTestInfoMapper();
		return testlist;
	}
}
