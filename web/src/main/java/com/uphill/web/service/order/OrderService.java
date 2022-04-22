package com.uphill.web.service.order;

import java.util.List;

import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;

public interface OrderService {
	int order(OrderVO orderVO, OrderItemVO orderItemVO, int purchase);
	int orderBasket(OrderVO orderVO, List<OrderItemVO> orderItemVO, int purchase);
}
