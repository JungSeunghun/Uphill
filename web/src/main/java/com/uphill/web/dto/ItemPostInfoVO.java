package com.uphill.web.dto;

import java.util.List;

public class ItemPostInfoVO {
	private ItemPostVO itemPostVO;
	private List<ItemOptionVO> itemOptionList;
	private ItemVO itemVO;
	
	public ItemPostInfoVO() {
		super();
	}

	public ItemPostInfoVO(ItemPostVO itemPostVO, List<ItemOptionVO> itemOptionList, ItemVO itemVO) {
		super();
		this.itemPostVO = itemPostVO;
		this.itemOptionList = itemOptionList;
		this.itemVO = itemVO;
	}

	public ItemPostVO getItemPostVO() {
		return itemPostVO;
	}

	public void setItemPostVO(ItemPostVO itemPostVO) {
		this.itemPostVO = itemPostVO;
	}

	public List<ItemOptionVO> getItemOptionList() {
		return itemOptionList;
	}

	public void setItemOptionList(List<ItemOptionVO> itemOptionList) {
		this.itemOptionList = itemOptionList;
	}

	public ItemVO getItemVO() {
		return itemVO;
	}

	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}
	
}
