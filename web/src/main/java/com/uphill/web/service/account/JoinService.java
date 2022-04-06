package com.uphill.web.service.account;

import com.uphill.web.dao.account.JoinDAO;
import com.uphill.web.dto.user.UserVO;

public class JoinService {
	public boolean join(UserVO userVO) {
		
		JoinDAO joinDAO = new JoinDAO();
		
		return joinDAO.insertUser(userVO);
		
	}
}
