package com.uphill.web.service.admin;

import com.uphill.web.dto.OrderInfoVO;
import com.uphill.web.dto.OrderListInfoVO;
import com.uphill.web.dto.UserListInfoVO;
import com.uphill.web.dto.UserVO;

public interface AdminService {
	UserListInfoVO getUserList(int page, int count);
	UserVO getUserInfo(int userIndex);
	int deleteUser(int userIndex);
	
	OrderListInfoVO getOrderList(int orderPage, int count);
	OrderInfoVO getOrderInfo(int orderIndex);
	int updateOrder(int orderState, int orderIndex);
}
