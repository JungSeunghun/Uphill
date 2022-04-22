package com.uphill.web.service.user;

import java.util.List;

import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;

public interface UserMapper {
	List<OrderVO> selectOrderList(int userIndex);
	List<OrderItemVO> selectOrderItemList(int userIndex);
}
