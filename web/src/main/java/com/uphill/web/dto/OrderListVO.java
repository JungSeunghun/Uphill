package com.uphill.web.dto;

import java.util.List;

public class OrderListVO {
	List<OrderVO> orderList;
	List<OrderItemVO> orderItemList;
	
	public OrderListVO() {
		super();
	}

	public OrderListVO(List<OrderVO> orderList, List<OrderItemVO> orderItemList) {
		super();
		this.orderList = orderList;
		this.orderItemList = orderItemList;
	}

	public List<OrderVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderVO> orderList) {
		this.orderList = orderList;
	}

	public List<OrderItemVO> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItemVO> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	
}
