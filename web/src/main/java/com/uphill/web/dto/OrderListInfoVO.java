package com.uphill.web.dto;

import java.util.List;

public class OrderListInfoVO {
	List<OrderVO> orderList;
	int totalCount;
	
	public OrderListInfoVO() {
		super();
	}

	public OrderListInfoVO(List<OrderVO> orderList, int totalCount) {
		super();
		this.orderList = orderList;
		this.totalCount = totalCount;
	}

	public List<OrderVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderVO> orderList) {
		this.orderList = orderList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}	
	
}
