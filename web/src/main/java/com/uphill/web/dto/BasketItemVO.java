package com.uphill.web.dto;

public class BasketItemVO {
	private int basketIndex;
	private int userIndex;
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
	private int itemTotalQty;
	
	public BasketItemVO() {
		super();
	}
	
	public BasketItemVO(int userIndex, int itemIndex, String optionName, int optionQty,
			int optionPrice, int itemCategoryIndex, String itemCategoryName, int itemSubcategoryIndex,
			String itemSubcategoryName, String itemName, String itemImage, float starRating, int itemPrice,
			int itemDiscountPrice, int itemTotalQty) {
		super();
		this.userIndex = userIndex;
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
		this.itemTotalQty = itemTotalQty;
	}

	public BasketItemVO(int basketIndex, int userIndex, int itemIndex, String optionName, int optionQty,
			int optionPrice, int itemCategoryIndex, String itemCategoryName, int itemSubcategoryIndex,
			String itemSubcategoryName, String itemName, String itemImage, float starRating, int itemPrice,
			int itemDiscountPrice, int itemTotalQty) {
		super();
		this.basketIndex = basketIndex;
		this.userIndex = userIndex;
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
		this.itemTotalQty = itemTotalQty;
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

	public int getItemTotalQty() {
		return itemTotalQty;
	}

	public void setItemTotalQty(int itemTotalQty) {
		this.itemTotalQty = itemTotalQty;
	}
	
}
