package com.uphill.web.service.user;

import com.uphill.web.dto.OrderListVO;
import com.uphill.web.dto.UserVO;

public interface UserService {
	OrderListVO getOrderList(int userIndex);
	UserVO updateUser(UserVO userVO);
	int leaveUser(int userIndex);
}
