package com.uphill.web.data.itemcategory.dto;

public class ItemCategoryVO {
	private int itemCategoryId;
	private String itemCategoryName;
	
	public ItemCategoryVO() {}
	
	public ItemCategoryVO(int itemCategoryId, String itemCategoryName) {
		super();
		this.itemCategoryId = itemCategoryId;
		this.itemCategoryName = itemCategoryName;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}
	
}
