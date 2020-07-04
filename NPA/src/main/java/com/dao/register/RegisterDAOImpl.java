package com.dao.register;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.register.UserDetails;

@Repository
public class RegisterDAOImpl implements RegisterDAO{
	
	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean registerUser(UserDetails details) {
		boolean userExists = false;
		int rowcount = jdbcTemplate.update("insert into register(firstname,lastname,gender,email,password,mobile,selecttest) values(?,?,?,?,?,?,?)",
				details.getFirstname(),details.getLastname(),details.getGender(),
				details.getEmail(),details.getPassword(),details.getMobile(),details.getSelecttest());
	

		
		if(rowcount==1){
			userExists = true;
		}
		return userExists;
	}

}
