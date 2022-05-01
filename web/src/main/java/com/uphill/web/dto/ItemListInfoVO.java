package com.uphill.web.dto;

import java.util.List;

public class ItemListInfoVO {
	List<ItemVO> itemList;
	int totalCount;
	
	public ItemListInfoVO() {
		super();
	}

	public ItemListInfoVO(List<ItemVO> itemList, int totalCount) {
		super();
		this.itemList = itemList;
		this.totalCount = totalCount;
	}

	public List<ItemVO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemVO> itemList) {
		this.itemList = itemList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
