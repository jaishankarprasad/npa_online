package com.dao.login;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.entity.login.LoginResponse;
import com.entity.login.User;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
    public LoginResponse authenticateUser(User user){
		
		
	List<LoginResponse>login = jdbcTemplate.query("select firstname,lastname from register where email ='"+user.getEmail()+"' and password = '"+user.getPassword()+"' and role ='"+user.getRole()+"'",new DetailsMapper());
		
		  return login.size()>0?login.get(0):null;
		  
	}
}
 class DetailsMapper implements RowMapper<LoginResponse>{
@Override
public LoginResponse mapRow(ResultSet rs, int arg1) throws SQLException {
	
	LoginResponse loginResponse=new LoginResponse();
	loginResponse.setFirstname(rs.getString(1));
	loginResponse.setLastname(rs.getString(2));
	return loginResponse;
}
}
 
 
 
 
 /*class DetailsMapper implements RowMapper<Details>{

 public Details mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Details details=new Details();
		details.setFirstname(rs.getString(1));
		details.setLastname(rs.getString(2));
		return details;
	}
 }
*/
 
/*	public boolean authenticateUser(User user) {
	 boolean uExists=false;

	 int rowcount= jdbcTemplate.queryForInt("select count(*) from register " +
	 		" where email=?and password = ? and role =?",user.getEmail(),user.getPassword(),user.getRole());

	 if(rowcount==1) {
	 	return true;
	 }
	 		return uExists;
	 	}
	 }
	 */
