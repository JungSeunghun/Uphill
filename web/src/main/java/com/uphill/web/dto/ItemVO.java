package com.uphill.web.dto;

public class ItemVO {
	private int itemIndex;
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
	private int itemSellCount;
		
	public ItemVO() {
		super();
	}
	
	public ItemVO(int itemCategoryIndex, String itemCategoryName, int itemSubcategoryIndex,
			String itemSubcategoryName, String itemName, String itemImage, int itemPrice, int itemDiscountPrice,
			int itemTotalQty) {
		super();
		this.itemCategoryIndex = itemCategoryIndex;
		this.itemCategoryName = itemCategoryName;
		this.itemSubcategoryIndex = itemSubcategoryIndex;
		this.itemSubcategoryName = itemSubcategoryName;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.itemPrice = itemPrice;
		this.itemDiscountPrice = itemDiscountPrice;
		this.itemTotalQty = itemTotalQty;
	}
	
	public ItemVO(int itemIndex, int itemCategoryIndex, String itemCategoryName, int itemSubcategoryIndex,
			String itemSubcategoryName, String itemName, String itemImage, int itemPrice, int itemDiscountPrice,
			int itemTotalQty) {
		super();
		this.itemIndex = itemIndex;
		this.itemCategoryIndex = itemCategoryIndex;
		this.itemCategoryName = itemCategoryName;
		this.itemSubcategoryIndex = itemSubcategoryIndex;
		this.itemSubcategoryName = itemSubcategoryName;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.itemPrice = itemPrice;
		this.itemDiscountPrice = itemDiscountPrice;
		this.itemTotalQty = itemTotalQty;
	}

	public ItemVO(int itemIndex, int itemCategoryIndex, String itemCategoryName, int itemSubcategoryIndex,
			String itemSubcategoryName, String itemName, String itemImage, float starRating, int itemPrice,
			int itemDiscountPrice, int itemTotalQty, int itemSellCount) {
		super();
		this.itemIndex = itemIndex;
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
		this.itemSellCount = itemSellCount;
	}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
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

	public int getItemSellCount() {
		return itemSellCount;
	}

	public void setItemSellCount(int itemSellCount) {
		this.itemSellCount = itemSellCount;
	}
	
}
