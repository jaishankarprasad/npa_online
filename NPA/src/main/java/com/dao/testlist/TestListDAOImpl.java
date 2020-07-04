package com.dao.testlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.testlist.TestDetails;

@Repository
public class TestListDAOImpl implements TestListDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public List<TestDetails> getAllTestDetailsRowMapper() {
		return jdbcTemplate.query("select * from testlist",new RowMapper<TestDetails>(){
			
			public TestDetails mapRow(ResultSet rs,int rownumber)throws SQLException{
				
				TestDetails details=new TestDetails();
				details.setTestId(rs.getString(2));
				details.setTestName(rs.getString(3));
				details.setNoQuestions(rs.getString(4));
				details.setTestTime(rs.getString(5));
				
				return details;
			}
		});
	}

}
