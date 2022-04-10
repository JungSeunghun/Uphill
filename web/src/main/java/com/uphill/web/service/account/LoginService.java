package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;
import com.uphill.web.dto.user.UserVO;

public class LoginService {
	public UserVO login(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.loginUser(userVO);
	}
	
	public String getSalt(String userId) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.selectUserSalt(userId);
	}
}
