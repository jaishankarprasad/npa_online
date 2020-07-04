package com.service.questionlist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.questionlist.QuestionListDAO;
import com.entity.questionlist.QuestionListDetails;
@Service
public class QuestionListServiceImpl implements  QuestionListService {
	
	@Autowired
	QuestionListDAO questionListDAO;

	@Override
	public List<QuestionListDetails> getQuestionbyTestname(String testname) {
		
		return questionListDAO.getQuestionbyTestname(testname);
	}

}
