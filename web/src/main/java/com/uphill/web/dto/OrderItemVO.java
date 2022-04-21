package com.uphill.web.dto;

public class OrderItemVO {
	private int orderItemIndex;
	private int orderIndex;
	private int itemIndex;
	private String optionName;
	private int optionQty;
	private int optionPrice;
	
	public OrderItemVO() {
		super();
	}

	public OrderItemVO(int orderItemIndex, int orderIndex, int itemIndex, String optionName,
			int optionQty, int optionPrice) {
		super();
		this.orderItemIndex = orderItemIndex;
		this.orderIndex = orderIndex;
		this.itemIndex = itemIndex;
		this.optionName = optionName;
		this.optionQty = optionQty;
		this.optionPrice = optionPrice;
	}

	public int getOrderItemIndex() {
		return orderItemIndex;
	}

	public void setOrderItemIndex(int orderItemIndex) {
		this.orderItemIndex = orderItemIndex;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getOptionQty() {
		return optionQty;
	}

	public void setOptionQty(int optionQty) {
		this.optionQty = optionQty;
	}

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	
}
