package com.uphill.web.data.item.dto;

public class ItemVO {
	private int itemId;
	private int itemCategoryId;
	private int itemSubcategoryId;
	private String itemName;
	private int itemPrice;
	private int itemDiscountPrice;
	private int itemDiscountPercent;
	private int itemQty;
	private int itemSellCount;
	private int itemSales;

	public ItemVO() {}
	
	public ItemVO(int itemId, int itemCategoryId, int itemSubcategoryId, String itemName, int itemPrice,
			int itemDiscountPrice, int itemDiscountPercent, int itemQty, int itemSellCount, int itemSales) {
		super();
		this.itemId = itemId;
		this.itemCategoryId = itemCategoryId;
		this.itemSubcategoryId = itemSubcategoryId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDiscountPrice = itemDiscountPrice;
		this.itemDiscountPercent = itemDiscountPercent;
		this.itemQty = itemQty;
		this.itemSellCount = itemSellCount;
		this.itemSales = itemSales;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public int getItemSubcategoryId() {
		return itemSubcategoryId;
	}

	public void setItemSubcategoryId(int itemSubcategoryId) {
		this.itemSubcategoryId = itemSubcategoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public int getItemSellCount() {
		return itemSellCount;
	}

	public void setItemSellCount(int itemSellCount) {
		this.itemSellCount = itemSellCount;
	}

	public int getItemSales() {
		return itemSales;
	}

	public void setItemSales(int itemSales) {
		this.itemSales = itemSales;
	}
	
}
