package com.uphill.web.data.itemoption.dto;

public class ItemOptionVO {
	private int itemOptionId;
	private int itemId;
	private String itemOptionTitle;
	private String itemOptionSubtitle;
	private int itemOptionPrice;
	private int itemOptionQty;
		
	public ItemOptionVO() {}

	public ItemOptionVO(int itemOptionId, int itemId, String itemOptionTitle, String itemOptionSubtitle,
			int itemOptionPrice, int itemOptionQty) {
		super();
		this.itemOptionId = itemOptionId;
		this.itemId = itemId;
		this.itemOptionTitle = itemOptionTitle;
		this.itemOptionSubtitle = itemOptionSubtitle;
		this.itemOptionPrice = itemOptionPrice;
		this.itemOptionQty = itemOptionQty;
	}

	public int getItemOptionId() {
		return itemOptionId;
	}

	public void setItemOptionId(int itemOptionId) {
		this.itemOptionId = itemOptionId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemOptionTitle() {
		return itemOptionTitle;
	}

	public void setItemOptionTitle(String itemOptionTitle) {
		this.itemOptionTitle = itemOptionTitle;
	}

	public String getItemOptionSubtitle() {
		return itemOptionSubtitle;
	}

	public void setItemOptionSubtitle(String itemOptionSubtitle) {
		this.itemOptionSubtitle = itemOptionSubtitle;
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
