package com.service.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.login.LoginDAO;
import com.entity.login.LoginResponse;
import com.entity.login.User;

@Service("loginService")
public class LoginServiceImpl  implements LoginService {
 
	@Autowired
	private LoginDAO loginDAO;

	@Override
	/*public boolean authenticateUser(User user) {
		return loginDAO.authenticateUser(user);
	}*/
 
	public LoginResponse authenticateUser(User user){
		return loginDAO.authenticateUser(user);
	}


}
