package com.uphill.web.dto;

public class ItemOptionVO {
	private int itemOptionIndex;
	private int itemIndex;
	private String itemOptionName;
	private String itemOptionContent;
	private int itemOptionPrice;
	private int itemOptionQty;
	
	public ItemOptionVO() {
		super();
	}
	
	public ItemOptionVO(String itemOptionName, String itemOptionContent, int itemOptionPrice, int itemOptionQty) {
		super();
		this.itemOptionName = itemOptionName;
		this.itemOptionContent = itemOptionContent;
		this.itemOptionPrice = itemOptionPrice;
		this.itemOptionQty = itemOptionQty;
	}

	public ItemOptionVO(int itemIndex, String itemOptionName, String itemOptionContent, int itemOptionPrice,
			int itemOptionQty) {
		super();
		this.itemIndex = itemIndex;
		this.itemOptionName = itemOptionName;
		this.itemOptionContent = itemOptionContent;
		this.itemOptionPrice = itemOptionPrice;
		this.itemOptionQty = itemOptionQty;
	}

	public ItemOptionVO(int itemOptionIndex, int itemIndex, String itemOptionName, String itemOptionContent,
			int itemOptionPrice, int itemOptionQty) {
		super();
		this.itemOptionIndex = itemOptionIndex;
		this.itemIndex = itemIndex;
		this.itemOptionName = itemOptionName;
		this.itemOptionContent = itemOptionContent;
		this.itemOptionPrice = itemOptionPrice;
		this.itemOptionQty = itemOptionQty;
	}

	public int getItemOptionIndex() {
		return itemOptionIndex;
	}

	public void setItemOptionIndex(int itemOptionIndex) {
		this.itemOptionIndex = itemOptionIndex;
	}

	public int getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(int itemIndex) {
		this.itemIndex = itemIndex;
	}

	public String getItemOptionName() {
		return itemOptionName;
	}

	public void setItemOptionName(String itemOptionName) {
		this.itemOptionName = itemOptionName;
	}

	public String getItemOptionContent() {
		return itemOptionContent;
	}

	public void setItemOptionContent(String itemOptionContent) {
		this.itemOptionContent = itemOptionContent;
	}

	public int getItemOptionPrice() {
		return itemOptionPrice;
	}

	public void setItemOptionPrice(int itemOptionPrice) {
		this.itemOptionPrice = itemOptionPrice;
	}

	public int getItemOptionQty() {
		return itemOptionQty;
	}

	public void setItemOptionQty(int itemOptionQty) {
		this.itemOptionQty = itemOptionQty;
	}
	
	
	
}
