package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;
import com.uphill.web.dto.user.UserVO;

public class LoginService {
	public UserVO login(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.loginUser(userVO);
	}
	
	public String getSalt(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.selectUserSalt(userVO);
	}
}
