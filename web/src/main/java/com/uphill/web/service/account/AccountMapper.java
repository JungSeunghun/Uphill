package com.uphill.web.service.account;

import com.uphill.web.dto.UserVO;

public interface AccountMapper {
	UserVO selectUser(UserVO userVO);
	UserVO selectLoginUser(UserVO userVO);
	String selectUserId(UserVO userVO);
	
	int insertUser(UserVO userVO);
	int updateUserPassword(UserVO userVO);
	
	boolean selectDuplicateUserId(String userId);
	boolean selectDuplicateEmail(String email);
	
}
