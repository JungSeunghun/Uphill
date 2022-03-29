package com.uphill.web.data.Basket.dto;

public class BasketVO {
	private int basketId; 
	private int userId; 
	private int itemId; 
	private int itemCount; 
	private int itemPrice; 
	private int itemDiscountPrice; 
	private int itemDiscountPercent;
	
	public BasketVO() {}
	
	public BasketVO(int basketId, int userId, int itemId, int itemCount, int itemPrice, int itemDiscountPrice,
			int itemDiscountPercent) {
		super();
		this.basketId = basketId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
		this.itemDiscountPrice = itemDiscountPrice;
		this.itemDiscountPercent = itemDiscountPercent;
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemDiscountPrice() {
		return itemDiscountPrice;
	}

	public void setItemDiscountPrice(int itemDiscountPrice) {
		this.itemDiscountPrice = itemDiscountPrice;
	}

	public int getItemDiscountPercent() {
		return itemDiscountPercent;
	}

	public void setItemDiscountPercent(int itemDiscountPercent) {
		this.itemDiscountPercent = itemDiscountPercent;
	} 
	
	
	
	
}
