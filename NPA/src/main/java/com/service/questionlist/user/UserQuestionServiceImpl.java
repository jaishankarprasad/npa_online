package com.service.questionlist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.questionlist.user.UserQuestionDAO;
import com.entity.questionlist.user.UserQuestionDetails;
@Service
public class UserQuestionServiceImpl implements UserQuestionService {

	@Autowired
UserQuestionDAO userQuestionDAO;
	@Override
	public UserQuestionDetails getQuestionsByQnum(String qnum) {
		return userQuestionDAO.getQuestionsByQnum(qnum);
	}

}
