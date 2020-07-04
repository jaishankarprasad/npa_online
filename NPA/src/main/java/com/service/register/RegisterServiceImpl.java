package com.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.register.RegisterDAO;
import com.entity.register.UserDetails;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	public boolean registerUser(UserDetails details) {
     return registerDAO.registerUser(details);
	}

}