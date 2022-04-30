package com.uphill.web.dto;

import java.util.List;

public class OrderInfoVO {
	OrderVO orderVO;
	List<OrderItemInfoVO> orderItemInfoList;
	
	public OrderInfoVO() {
		super();
	}

	public OrderInfoVO(OrderVO orderVO, List<OrderItemInfoVO> orderItemInfoList) {
		super();
		this.orderVO = orderVO;
		this.orderItemInfoList = orderItemInfoList;
	}

	public OrderVO getOrderVO() {
		return orderVO;
	}

	public void setOrderVO(OrderVO orderVO) {
		this.orderVO = orderVO;
	}

	public List<OrderItemInfoVO> getOrderItemInfoList() {
		return orderItemInfoList;
	}

	public void setOrderItemInfoList(List<OrderItemInfoVO> orderItemInfoList) {
		this.orderItemInfoList = orderItemInfoList;
	}

}
