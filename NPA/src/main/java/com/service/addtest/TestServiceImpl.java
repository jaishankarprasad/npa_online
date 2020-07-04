package com.service.addtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.addtest.TestDAO;
import com.entity.addtest.TestInfo;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDAO testDAO;
	
	public boolean addTest(TestInfo details) {
        
		return testDAO.addTest(details);
	}

}
