package com.dao.login;



import com.entity.login.LoginResponse;
import com.entity.login.User;

public interface LoginDAO{
/*	public abstract boolean authenticateUser(User user);
*/	public LoginResponse authenticateUser(User user);


	}
