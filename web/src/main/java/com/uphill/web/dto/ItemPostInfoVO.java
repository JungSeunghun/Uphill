package com.uphill.web.dto;

import java.util.List;

public class ItemPostInfoVO {
	private ItemPostVO itemPostVO;
	private List<ItemOptionVO> itemOptionList;
	private ItemVO itemVO;
	private List<ReviewVO> reviewList;
	private List<AskVO> askList;
	int reviewCount;
	int askCount;
	
	public ItemPostInfoVO() {
		super();
	}

	public ItemPostInfoVO(ItemPostVO itemPostVO, List<ItemOptionVO> itemOptionList, ItemVO itemVO,
			List<ReviewVO> reviewList, List<AskVO> askList, int reviewCount, int askCount) {
		super();
		this.itemPostVO = itemPostVO;
		this.itemOptionList = itemOptionList;
		this.itemVO = itemVO;
		this.reviewList = reviewList;
		this.askList = askList;
		this.reviewCount = reviewCount;
		this.askCount = askCount;
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

	public List<ReviewVO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewVO> reviewList) {
		this.reviewList = reviewList;
	}

	public List<AskVO> getAskList() {
		return askList;
	}

	public void setAskList(List<AskVO> askList) {
		this.askList = askList;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getAskCount() {
		return askCount;
	}

	public void setAskCount(int askCount) {
		this.askCount = askCount;
	}
	
}
