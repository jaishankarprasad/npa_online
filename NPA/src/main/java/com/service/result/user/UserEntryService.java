package com.service.result.user;

import com.entity.result.user.Attempted;

public interface UserEntryService {
	
	public abstract boolean insertResult(Attempted attempted);
}
