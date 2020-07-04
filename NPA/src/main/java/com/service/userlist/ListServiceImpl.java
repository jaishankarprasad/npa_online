package com.service.userlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.userlist.ListDAO;
import com.entity.userlist.UserList;

@Service
public class ListServiceImpl implements ListService {
	
	@Autowired
	ListDAO listDAO;

	@Override
	public List<UserList> getAllDetailsRowMapper() {
	 
		return listDAO.getAllDetailsRowMapper();
	}


}
