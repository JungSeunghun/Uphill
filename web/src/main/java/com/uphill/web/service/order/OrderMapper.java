package com.uphill.web.service.order;

import java.util.List;
import java.util.Map;

import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;

public interface OrderMapper {
	int selectOrderIndex();
	int insertOrder(OrderVO orderVO);
	int insertOrderItem(Map<String, List<OrderItemVO>> map);
	int updatePoint(Map<String, Integer> map);
}
