package com.uphill.web.service.user;

import java.util.List;

import com.uphill.web.dto.OrderItemInfoVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserVO;

public interface UserMapper {
	List<OrderVO> selectOrderList(int userIndex);
	List<OrderItemInfoVO> selectOrderItemList(List<Integer> orderListIndex);
	int updateUser(UserVO userVO);
	int deleteUser(int userIndex);
}
