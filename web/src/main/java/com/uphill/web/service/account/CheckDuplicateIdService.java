package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;

public class CheckDuplicateIdService {
	
	public boolean checkDuplicateIdService(String userEnterId) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.selectUserEnterId(userEnterId);
	}
	
}
