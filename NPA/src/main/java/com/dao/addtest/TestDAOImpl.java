package com.dao.addtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.addtest.TestInfo;

@Repository
public class TestDAOImpl implements TestDAO {
	
	@Autowired(required=true)
    JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public boolean addTest(TestInfo details) {
		
		
          boolean testExists=false;
          int rowcount=jdbcTemplate.update("insert into testlist(testid,testname,noquestions,testtime) values(?,?,?,?)"
        		  ,details.getTestId(),details.getTestName(),details.getNoQuestions(),details.getTestTime());
		
          if(rowcount==1) {
        	  testExists=true;
          }
		return testExists;
	}

}

