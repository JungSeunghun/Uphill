package com.uphill.web.data.itemsubcategory.dto;

public class ItemSubcategoryVO {
	private int itemSubcategoryId;
	private int itemCategoryId;
	private String itemSubcategoryName;
	
	public ItemSubcategoryVO() {}

	public ItemSubcategoryVO(int itemSubcategoryId, int itemCategoryId, String itemSubcategoryName) {
		super();
		this.itemSubcategoryId = itemSubcategoryId;
		this.itemCategoryId = itemCategoryId;
		this.itemSubcategoryName = itemSubcategoryName;
	}

	public int getItemSubcategoryId() {
		return itemSubcategoryId;
	}

	public void setItemSubcategoryId(int itemSubcategoryId) {
		this.itemSubcategoryId = itemSubcategoryId;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemSubcategoryName() {
		return itemSubcategoryName;
	}

	public void setItemSubcategoryName(String itemSubcategoryName) {
		this.itemSubcategoryName = itemSubcategoryName;
	}
	
}
