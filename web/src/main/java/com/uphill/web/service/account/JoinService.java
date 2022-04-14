package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;
import com.uphill.web.dto.UserVO;

public class JoinService {
	public boolean join(UserVO userVO) {		
		UserDAO userDAO = new UserDAO();
		
		int result = userDAO.insertUser(userVO);

		if(result > 0) {
			return true;			
		} else {
			return false;
		}		
	}
}
