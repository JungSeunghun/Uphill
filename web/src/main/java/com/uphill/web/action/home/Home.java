package com.uphill.web.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.HomeVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.MainBannerVO;
import com.uphill.web.dto.ReviewVO;
import com.uphill.web.service.home.HomeServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class Home implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		HomeServiceImpl homeService  = new HomeServiceImpl();
		HomeVO homeVO = homeService.getMainPage();
		
		List<MainBannerVO> mainBannerList = homeVO.getMainBannerList();
		List<ItemVO> bestSellerList = homeVO.getBestSellerList();
		List<ItemVO> bestItemList = homeVO.getBestItemList();
		List<ReviewVO> recentReviewList = homeVO.getRecentReviewList();
		
		request.setAttribute("mainBannerList", mainBannerList);
		request.setAttribute("bestSellerList", bestSellerList);
		request.setAttribute("bestItemList", bestItemList);
		request.setAttribute("recentReviewList", recentReviewList);		
		
		return new ViewResolver("/views/home/home.tiles");
	}
	
}
