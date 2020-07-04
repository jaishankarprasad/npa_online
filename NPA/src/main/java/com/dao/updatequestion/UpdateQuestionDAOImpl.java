package com.dao.updatequestion;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.updatequestion.UpdateQuestionDetails;

@Repository
public class UpdateQuestionDAOImpl implements UpdateQuestionDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean updateAllQuestions(UpdateQuestionDetails det) {
		boolean update=false;

		int rowcount=jdbcTemplate.update("update question set question=?,option1=?,option2=?,option3=?,option4=?,correctoption=? where testname=? and q_no=?",
				det.getQuestion(),det.getOption1(),
				det.getOption2(),det.getOption3(),det.getOption4(),
				det.getCorrectoption(),det.getTestname(),det.getQnum());
			if(rowcount==1) {
				update=true;
			}
		return update;
	}
	
}