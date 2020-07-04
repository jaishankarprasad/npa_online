package com.dao.result.user;

import com.entity.result.user.Attempted;

public interface UserEntryDAO {

	public abstract boolean insertResult(Attempted attempted);
}