package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;
import com.uphill.web.dto.user.UserVO;

public class UserIdFindService {
	public String userIdFindService(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		String userId = userDAO.selectUserId(userVO);
		
		return userId;
	}
	
}
