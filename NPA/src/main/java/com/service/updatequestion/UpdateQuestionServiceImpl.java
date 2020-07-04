package com.service.updatequestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.updatequestion.UpdateQuestionDAO;
import com.entity.updatequestion.UpdateQuestionDetails;
@Service
public class UpdateQuestionServiceImpl implements UpdateQuestionService{

	@Autowired
	UpdateQuestionDAO updateQuestionDAO;

	
	@Override
	public boolean updateQuestions(UpdateQuestionDetails det) {
		
	return updateQuestionDAO.updateAllQuestions(det);
	}
	

}
