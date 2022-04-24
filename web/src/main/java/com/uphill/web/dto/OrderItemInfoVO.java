package com.uphill.web.dto;

public class OrderItemInfoVO {
	private int orderItemIndex;
	private int orderIndex;
	private int itemIndex;
	private String optionName;
	private int optionQty;
	private int optionPrice;
	private int itemCategoryIndex;
	private String itemCategoryName;
	private int itemSubcategoryIndex;
	private String itemSubcategoryName;
	private String itemName;
	private String itemImage;
	private float starRating;
	private int itemPrice;
	private int itemDiscountPrice;
	
	public OrderItemInfoVO() {
		super();
	}

	public OrderItemInfoVO(int orderItemIndex, int orderIndex, int itemIndex, String optionName, int optionQty,
			int optionPrice, int itemCategoryIndex, String itemCategoryName, int itemSubcategoryIndex,
			String itemSubcategoryName, String itemName, String itemImage, float starRating, int itemPrice,
			int itemDiscountPrice) {
		super();
		this.orderItemIndex = orderItemIndex;
		this.orderIndex = orderIndex;
		this.itemIndex = itemIndex;
		this.optionName = optionName;
		this.optionQty = optionQty;
		this.optionPrice = optionPrice;
		this.itemCategoryIndex = itemCategoryIndex;
		this.itemCategoryName = itemCategoryName;
		this.itemSubcategoryIndex = itemSubcategoryIndex;
		this.itemSubcategoryName = itemSubcategoryName;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.starRating = starRating;
		this.itemPrice = itemPrice;
		this.itemDiscountPrice = itemDiscountPrice;
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

	public int getItemCategoryIndex() {
		return itemCategoryIndex;
	}

	public void setItemCategoryIndex(int itemCategoryIndex) {
		this.itemCategoryIndex = itemCategoryIndex;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public int getItemSubcategoryIndex() {
		return itemSubcategoryIndex;
	}

	public void setItemSubcategoryIndex(int itemSubcategoryIndex) {
		this.itemSubcategoryIndex = itemSubcategoryIndex;
	}

	public String getItemSubcategoryName() {
		return itemSubcategoryName;
	}

	public void setItemSubcategoryName(String itemSubcategoryName) {
		this.itemSubcategoryName = itemSubcategoryName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public float getStarRating() {
		return starRating;
	}

	public void setStarRating(float starRating) {
		this.starRating = starRating;
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
	
}
