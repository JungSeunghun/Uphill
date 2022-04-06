package com.uphill.web.service.account;

import com.uphill.web.dao.account.LoginDAO;
import com.uphill.web.dto.user.UserVO;

public class LoginService {
	public boolean login(UserVO userVO) {
		LoginDAO loginDAO = new LoginDAO();
		boolean result = loginDAO.selectUser(userVO);
		return result;
	}
}
