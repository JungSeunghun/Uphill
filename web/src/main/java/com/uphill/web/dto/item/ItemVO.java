package com.uphill.web.dto.item;

public class ItemVO {
	private int itemIndex;
	private int itemCategoryIndex;
	private int itemSubcategoryIndex;
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
	public int getItemSubcategoryIndex() {
		return itemSubcategoryIndex;
	}
	public void setItemSubcategoryIndex(int itemSubcategoryIndex) {
		this.itemSubcategoryIndex = itemSubcategoryIndex;
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
