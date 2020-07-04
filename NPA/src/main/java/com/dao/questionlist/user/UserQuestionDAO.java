package com.dao.questionlist.user;

import com.entity.questionlist.user.UserQuestionDetails;

public interface UserQuestionDAO {
	public UserQuestionDetails getQuestionsByQnum(String qnum);

}
