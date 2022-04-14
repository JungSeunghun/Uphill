package com.uphill.web.service.home;

import java.util.List;

import com.uphill.web.dao.ItemDAO;
import com.uphill.web.dao.MainBannerDAO;
import com.uphill.web.dao.ReviewDAO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.MainBannerVO;
import com.uphill.web.dto.ReviewVO;

public class HomeService {

	public List<MainBannerVO> getMainBannerList() {
		MainBannerDAO mainBannerDAO = new MainBannerDAO();
		
		return mainBannerDAO.selectMainBannerList();
	}
	
	public List<ItemVO> getBestSellerList(int categoryIndex, int count) {
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectBestSellerList(categoryIndex, count);
	}
	
	public List<ItemVO> getBestItemList(int count) {
		ItemDAO itemDAO = new ItemDAO();
		
		return itemDAO.selectBestItemList(count);
	}
	
	public List<ReviewVO> getRecentReviewList(int count) {
		ReviewDAO reviewDAO = new ReviewDAO();
		
		return reviewDAO.selectRecentReviewList(count);
	}

}
