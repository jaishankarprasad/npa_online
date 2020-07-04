package com.service.login;



import com.entity.login.LoginResponse;
import com.entity.login.User;

public interface LoginService {

	public LoginResponse authenticateUser(User user);
/*	public abstract boolean authenticateUser(User user);
*/

}

