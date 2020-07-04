package com.dao.questionlist.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.questionlist.user.UserQuestionDetails;
@Repository
public class UserQuestionDAOImpl implements UserQuestionDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public UserQuestionDetails getQuestionsByQnum(String qnum) {
		return (UserQuestionDetails) jdbcTemplate.queryForObject
				("select q.q_no,t.testname,q.question,q.option1,q.option2,q.option3,q.option4 from question q INNER JOIN testlist t on q.testname=t.testname where q.q_no=?;",
						new Object[] { qnum },new RowMapper() {

			@Override
			public UserQuestionDetails mapRow(ResultSet rs, int rownum) throws SQLException {

				UserQuestionDetails uqd=new UserQuestionDetails();
				uqd.setQnum(rs.getString("q_no"));
				uqd.setTestname(rs.getString("testname"));
				uqd.setQuestion(rs.getString("question"));
				uqd.setOption1(rs.getString("option1"));
				uqd.setOption2(rs.getString("option2"));
				uqd.setOption3(rs.getString("option3"));
				uqd.setOption4(rs.getString("option4"));
				return uqd;
			}	
		});
	}
}
/*"select q.q_no,t.testname,q.question,q.option1,q.option2,q.option3,q.option4 from question q INNER JOIN testlist t on q.testid=t.testid where q_no=?;"*/