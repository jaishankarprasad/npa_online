package com.dao.addquestion;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.addquestion.QuestionDetails;
@Repository
public class AddQuestionDAOImpl implements AddQuestionDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addQuestion(QuestionDetails questionDetails) {

		boolean questionadded=false;
		int rowcount=jdbcTemplate.update("insert into question(question,option1,option2,option3,option4,correctoption,testname) values(?,?,?,?,?,?,?)",
			questionDetails.getQuestion(),questionDetails.getOption1(),
				questionDetails.getOption2(),questionDetails.getOption3(),questionDetails.getOption4(),
				questionDetails.getCorrectoption(),questionDetails.getTestname());
		if(rowcount==1) {
			questionadded=true;
		}
		
		return questionadded;
	}

}
