package com.service.testlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.testlist.TestListDAO;
import com.entity.testlist.TestDetails;

@Service
public class TestListServiceImpl implements TestListService {
	
	@Autowired
	TestListDAO testListDAO;

	@Override
	public List<TestDetails> getAllTestDetailsRowMapper() {
		return testListDAO.getAllTestDetailsRowMapper();
	}

}
