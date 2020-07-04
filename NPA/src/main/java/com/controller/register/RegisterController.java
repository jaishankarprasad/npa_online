package com.controller.register;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.entity.register.RegisterResponse;
import com.entity.register.UserDetails;
import com.service.register.RegisterService;
@CrossOrigin(origins= "http://localhost:4200" ,maxAge = 3600)
@RestController
	public class RegisterController {

		@Autowired
		RegisterService registerService;
		
		@RequestMapping(value="/register", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public RegisterResponse doRegister(@RequestBody UserDetails details)throws ParseException  {
			RegisterResponse registerResponse = new RegisterResponse();
		
			System.out.println("Inside doRegister method"); 

			if(!registerService.registerUser(details)) {
				registerResponse.setErrorMessage("Invalid credentials");
				registerResponse.setStatus("false");
			} 
			registerResponse.setSuccessMessage("successfully registered");
			registerResponse.setStatus("true");
		return registerResponse;

}
}
