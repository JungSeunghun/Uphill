package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;

public class CheckDuplicateEmailService {
	public boolean checkDuplicateEmailService(String email) {
		UserDAO userDAO = new UserDAO();
		
		return userDAO.selectDuplicateEmail(email);
	}
}
