package com.uphill.web.dto;

import java.util.List;

public class ItemInfoVO {
	ItemVO itemVO;
	List<ItemOptionVO> itemOptionList;
	
	public ItemInfoVO() {
		super();
	}

	public ItemInfoVO(ItemVO itemVO, List<ItemOptionVO> itemOptionList) {
		super();
		this.itemVO = itemVO;
		this.itemOptionList = itemOptionList;
	}

	public ItemVO getItemVO() {
		return itemVO;
	}

	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}

	public List<ItemOptionVO> getItemOptionList() {
		return itemOptionList;
	}

	public void setItemOptionList(List<ItemOptionVO> itemOptionList) {
		this.itemOptionList = itemOptionList;
	}
	
}
