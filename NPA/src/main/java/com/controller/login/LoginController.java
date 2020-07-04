package com.controller.login;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.entity.login.LoginResponse;
import com.entity.login.User;
import com.service.login.LoginService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600)
@RestController
public class LoginController {

	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired(required=true)
	LoginService loginService;
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LoginResponse doLogin(@RequestBody User user)throws ParseException  {
		
	LoginResponse loginResponse = loginService.authenticateUser(user);
	try {
		logger.info("checking validation");
		if(loginResponse!=null)
			
            {
			loginResponse.setSuccessMessage("Login successful");
	        loginResponse.setStatus("TRUE");
	        loginResponse.setFirstname(loginResponse.getFirstname());
	        loginResponse.setLastname(loginResponse.getLastname());
		   }
		 else {
			 LoginResponse lR=new LoginResponse();
			 lR.setErrorMessage("Invalid credentials");
			 lR.setStatus("FALSE");
			 return lR;
	         }
		logger.info("after validation");
		}
		catch(NullPointerException ne) {
			System.out.println("exception occured"+ne);
		}
	return loginResponse;
		
/*		LoginResponse loginResponse = new LoginResponse();

		if(loginService.authenticateUser(user))
            {
			loginResponse.setSuccessMessage("Login successful");
	        loginResponse.setStatus("TRUE");
		   }
		 else {
			 loginResponse.setErrorMessage("Invalid credentials");
			 loginResponse.setStatus("FALSE");
	         }
		
	return loginResponse;*/
}
		
}