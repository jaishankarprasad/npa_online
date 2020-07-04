package com.dao.testlist;

import java.util.List;

import com.entity.testlist.TestDetails;

public interface TestListDAO {
	public List<TestDetails> getAllTestDetailsRowMapper();

}
