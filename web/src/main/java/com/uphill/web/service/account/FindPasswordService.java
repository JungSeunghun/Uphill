package com.uphill.web.service.account;

import com.uphill.web.dao.UserDAO;
import com.uphill.web.dto.UserVO;

public class FindPasswordService {
	
	public boolean updatePassword(UserVO userVO) {
		UserDAO userDAO = new UserDAO();
		
		String salt = userDAO.selectUserSalt(userVO.getUserId());
		userVO.setSalt(salt);
		
		int result =  userDAO.updateUserPassword(userVO);
		
		if(result > 0) {
			return true;
		} else {
			return false;			
		}
	}
}
