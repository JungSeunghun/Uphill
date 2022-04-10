package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;

public class UserIdFindService {
	public String userIdFindService(String email) {
		UserDAO userDAO = new UserDAO();
		String userEnterId = userDAO.selectUserEnterIdWithEmail(email);
		
		return userEnterId;
	}
	
}
