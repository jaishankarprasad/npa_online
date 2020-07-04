package com.service.testlist.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.testlist.user.UserTestDAO;
import com.entity.testlist.user.UserTestDetails;
@Service
public class UserTestServiceImpl implements UserTestService{
@Autowired
UserTestDAO userTestDAO;
	
	
	@Override
	public List<UserTestDetails> getTestInfoMapper() {

		return userTestDAO.getTestInfoMapper();
	}

}
