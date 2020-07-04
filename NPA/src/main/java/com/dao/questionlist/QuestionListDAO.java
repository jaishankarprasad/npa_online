package com.dao.questionlist;

import java.util.List;

import com.entity.questionlist.QuestionListDetails;

public interface QuestionListDAO {
	public List<QuestionListDetails> getQuestionbyTestname(String testname);

}
