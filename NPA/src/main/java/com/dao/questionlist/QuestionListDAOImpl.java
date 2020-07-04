package com.dao.questionlist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.questionlist.QuestionListDetails;

@Repository
public class QuestionListDAOImpl implements QuestionListDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<QuestionListDetails> getQuestionbyTestname(String testname) {
		return jdbcTemplate.query("select * from question where testname=?;", new Object[] { testname },new RowMapper<QuestionListDetails> (){
			@Override
			public QuestionListDetails mapRow(ResultSet rs, int rownumber) throws SQLException {

				QuestionListDetails qld=new QuestionListDetails();
				qld.setQnum(rs.getString(1));
				qld.setQuestion(rs.getString(2));
				qld.setOption1(rs.getString(3));
				qld.setOption2(rs.getString(4));
				qld.setOption3(rs.getString(5));
				qld.setOption4(rs.getString(6));
				qld.setCorrectoption(rs.getString(7));
				return qld;
			}		
	 }
   );
 }
}
