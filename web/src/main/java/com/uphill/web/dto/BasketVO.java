package com.uphill.web.dto;

public class BasketVO {
	private int basketIndex;
	private int userIndex;
	private int itemIndex;
	private String optionName;
	private int optionQty;
	private int optionPrice;
	
	public BasketVO() {
		super();
	}
	
	public BasketVO(int basketIndex, int userIndex, int itemIndex, String optionName, int optionQty, int optionPrice) {
		super();
		this.basketIndex = basketIndex;
		this.userIndex = userIndex;
		this.itemIndex = itemIndex;
		this.optionName = optionName;
		this.optionQty = optionQty;
		this.optionPrice = optionPrice;
	}
	
	public int getBasketIndex() {
		return basketIndex;
	}
	public void setBasketIndex(int basketIndex) {
		this.basketIndex = basketIndex;
	}
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
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
