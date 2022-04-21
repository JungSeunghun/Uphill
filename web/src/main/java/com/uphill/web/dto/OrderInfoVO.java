package com.uphill.web.dto;

import java.util.List;

public class OrderInfoVO {
	private OrderVO orderVO;
	private List<OrderItemVO> orderItemList;
	
	public OrderInfoVO() {
		super();
	}

	public OrderInfoVO(OrderVO orderVO, List<OrderItemVO> orderItemList) {
		super();
		this.orderVO = orderVO;
		this.orderItemList = orderItemList;
	}

	public OrderVO getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}

	public List<OrderItemVO> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemVO> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
}
