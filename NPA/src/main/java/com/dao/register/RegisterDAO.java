package com.dao.register;

import com.entity.register.UserDetails;

public interface RegisterDAO {
	
		public abstract boolean registerUser(UserDetails details);

}
