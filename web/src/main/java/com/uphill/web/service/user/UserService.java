package com.uphill.web.service.user;

import com.uphill.web.dto.OrderListVO;

public interface UserService {
	OrderListVO getOrderList(int userIndex);
}
