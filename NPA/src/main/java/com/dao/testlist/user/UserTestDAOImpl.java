package com.dao.testlist.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.testlist.user.UserTestDetails;

@Repository
public class UserTestDAOImpl implements UserTestDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<UserTestDetails> getTestInfoMapper() {
       return jdbcTemplate.query("select * from testlist",new RowMapper<UserTestDetails>(){

		@Override
		public UserTestDetails mapRow(ResultSet rs, int rownumber) throws SQLException {

			UserTestDetails utd=new UserTestDetails();
			utd.setTestname(rs.getString(3));
			utd.setNoQuestions(rs.getString(4));
			utd.setTesttime(rs.getString(5));
			return utd;
		}	
		});
	}
}
