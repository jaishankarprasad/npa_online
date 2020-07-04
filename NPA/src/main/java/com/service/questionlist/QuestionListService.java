package com.service.questionlist;

import java.util.List;

import com.entity.questionlist.QuestionListDetails;

public interface QuestionListService {
	public List<QuestionListDetails> getQuestionbyTestname(String testname);

}
