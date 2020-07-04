package com.service.result.user;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.result.user.UserEntryDAO;
import com.entity.result.user.Attempted;
@Service
public class UserEntryServiceImpl implements UserEntryService{
	
	@Autowired
	UserEntryDAO userEntryDAO;

	@Override
	public boolean insertResult(Attempted attempted) {
	
		return userEntryDAO.insertResult(attempted);
	}

}
