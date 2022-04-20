package com.uphill.web.service.account;

import com.uphill.web.dto.UserVO;

public interface AccountService {
	UserVO login(UserVO userVO);	
	String findUserId(UserVO userVO);
	
	int join(UserVO userVO);	
	public int updatePassword(UserVO userVO);
	
	public boolean checkDuplicateId(String userId);	
	public boolean checkDuplicateEmail(String email);
}
