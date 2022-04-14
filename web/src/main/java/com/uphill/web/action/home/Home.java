package com.uphill.web.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.MainBannerVO;
import com.uphill.web.dto.ReviewVO;
import com.uphill.web.service.home.HomeService;
import com.uphill.web.viewresolver.ViewResolver;

public class Home implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		HomeService homeService  = new HomeService();
		List<MainBannerVO> mainBannerList = homeService.getMainBannerList();
		List<ItemVO> bestSellerList =  homeService.getBestSellerList(1, 4); // category=1, count=3
		List<ItemVO> bestItemList =  homeService.getBestItemList(6); // count=6
		List<ReviewVO> recentReviewList = homeService.getRecentReviewList(8);
		
		request.setAttribute("mainBannerList", mainBannerList);
		request.setAttribute("bestSellerList", bestSellerList);
		request.setAttribute("bestItemList", bestItemList);
		request.setAttribute("recentReviewList", recentReviewList);		
		
		return new ViewResolver("/views/home/home.tiles");
	}
	
}
