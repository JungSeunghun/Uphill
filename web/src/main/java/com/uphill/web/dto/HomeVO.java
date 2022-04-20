package com.uphill.web.dto;

import java.util.List;

public class HomeVO {
	private List<MainBannerVO> mainBannerList;
	private List<ItemVO> bestSellerList;
	private List<ItemVO> bestItemList;
	private List<ReviewVO> recentReviewList;
	
	public HomeVO() {
		super();
	}
	
	public HomeVO(List<MainBannerVO> mainBannerList, List<ItemVO> bestSellerList, List<ItemVO> bestItemList,
			List<ReviewVO> recentReviewList) {
		super();
		this.mainBannerList = mainBannerList;
		this.bestSellerList = bestSellerList;
		this.bestItemList = bestItemList;
		this.recentReviewList = recentReviewList;
	}

	public List<MainBannerVO> getMainBannerList() {
		return mainBannerList;
	}

	public void setMainBannerList(List<MainBannerVO> mainBannerList) {
		this.mainBannerList = mainBannerList;
	}

	public List<ItemVO> getBestSellerList() {
		return bestSellerList;
	}

	public void setBestSellerList(List<ItemVO> bestSellerList) {
		this.bestSellerList = bestSellerList;
	}

	public List<ItemVO> getBestItemList() {
		return bestItemList;
	}

	public void setBestItemList(List<ItemVO> bestItemList) {
		this.bestItemList = bestItemList;
	}

	public List<ReviewVO> getRecentReviewList() {
		return recentReviewList;
	}

	public void setRecentReviewList(List<ReviewVO> recentReviewList) {
		this.recentReviewList = recentReviewList;
	}	
}