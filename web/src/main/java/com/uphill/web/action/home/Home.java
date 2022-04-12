package com.uphill.web.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.item.ItemVO;
import com.uphill.web.dto.mainbanner.MainBannerVO;
import com.uphill.web.dto.review.ReviewVO;
import com.uphill.web.service.home.HomeService;
import com.uphill.web.viewresolver.ViewResolver;

public class Home implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		HomeService homeService  = new HomeService();
		List<MainBannerVO> mainBannerList = homeService.getMainBannerList();
		List<ItemVO> bestSellerList =  homeService.getBestSellerList(1, 3); // category=1, count=3
		List<ItemVO> bestItemList =  homeService.getBestItemList(6); // count=6
		List<ReviewVO> recentReviewList = homeService.getRecentReviewList(5);
		
		request.setAttribute("mainBannerList", mainBannerList);
		request.setAttribute("bestSellerList", bestSellerList);
		request.setAttribute("bestItemList", bestItemList);
		request.setAttribute("recentReviewList", recentReviewList);		
		
		return new ViewResolver("/views/home/home.tiles");
	}
	
}
