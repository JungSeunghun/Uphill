package com.uphill.web.service.order;

import java.util.List;
import java.util.Map;

import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;

public interface OrderMapper {
	int selectOrderIndex();
	int insertOrder(OrderVO orderVO);
	int insertOrderItem(OrderItemVO orderItemVO);
	int insertOrderItemList(Map<String, List<OrderItemVO>> orderItemMap);
	int updateUser(Map<String, Integer> map);
	int deleteBasket(int userIndex);
}
