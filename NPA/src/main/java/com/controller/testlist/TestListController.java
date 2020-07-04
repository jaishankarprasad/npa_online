package com.controller.testlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.testlist.TestDetails;
import com.service.testlist.TestListService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600)
@RestController
public class TestListController {

	
	@Autowired
	TestListService testListService;
	@ResponseBody
	@RequestMapping(value="/gettestlist",method=RequestMethod.GET)
	
	public List<TestDetails> getTestDetails() {
		List<TestDetails> details=testListService.getAllTestDetailsRowMapper();
		return details;
		
	}
	
}