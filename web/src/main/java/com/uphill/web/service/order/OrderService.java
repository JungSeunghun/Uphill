package com.uphill.web.service.order;

import java.util.List;

import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserVO;

public interface OrderService {
	UserVO order(OrderVO orderVO, OrderItemVO orderItemVO, int purchase);
	UserVO orderBasket(OrderVO orderVO, List<OrderItemVO> orderItemVO, int purchase);
}
