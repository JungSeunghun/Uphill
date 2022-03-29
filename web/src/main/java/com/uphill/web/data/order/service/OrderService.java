package com.uphill.web.data.order.service;

import java.util.List;

import com.uphill.web.data.order.dto.OrderVO;

public interface OrderService {
	List<OrderVO> getAllOrders();
	OrderVO getOrder(int orderId);
	boolean registOrder(OrderVO orderVO);
	boolean updateOrder(OrderVO orderVO);
	boolean deleteOrder(OrderVO orderVO);
}
