package com.uphill.web.dto;

import java.util.List;

public class OrderListVO {
	List<OrderVO> orderList;
	List<OrderItemInfoVO> orderItemInfoList;
	
	public OrderListVO() {
		super();
	}

	public OrderListVO(List<OrderVO> orderList, List<OrderItemInfoVO> orderItemInfoList) {
		super();
		this.orderList = orderList;
		this.orderItemInfoList = orderItemInfoList;
	}

	public List<OrderVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderVO> orderList) {
		this.orderList = orderList;
	}

	public List<OrderItemInfoVO> getOrderItemInfoList() {
		return orderItemInfoList;
	}

	public void setOrderItemInfoList(List<OrderItemInfoVO> orderItemInfoList) {
		this.orderItemInfoList = orderItemInfoList;
	}

	
	
}
