package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;
import com.uphill.web.dto.user.UserVO;

public class JoinService {
	public boolean join(UserVO userVO) {
		
		UserDAO userDAO = new UserDAO();
		
		return userDAO.insertUser(userVO);
		
	}
}
