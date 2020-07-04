package com.service.addquestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.addquestion.AddQuestionDAO;
import com.entity.addquestion.QuestionDetails;
@Service
public class AddQuestionServiceImpl implements AddQuestionService{
	
	@Autowired
	AddQuestionDAO addQuestionDAO;

	@Override
	public boolean addQuestion(QuestionDetails questionDetails) {
		
		return addQuestionDAO.addQuestion(questionDetails);
	}

}
