package com.dao.userlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.userlist.UserList;

@Repository
public class ListDAOImpl implements ListDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
 public List<UserList> getAllDetailsRowMapper(){
	return jdbcTemplate.query
			("select * from register",new RowMapper<UserList>(){
				
		      public UserList mapRow(ResultSet rs, int rownumber) throws SQLException {
		    	  UserList user=new UserList();
		    	 
		    	 user.setFirstname(rs.getString(1));
		    	 user.setLastname(rs.getString(2));
		    	  user.setEmail(rs.getString(3));
		    	  user.setSelecttest(rs.getString(5));
		    	  user.setMobile(rs.getString(8));
		    	  user.setCreatedon(rs.getString(6));
            return user;
}
});
	
}
}