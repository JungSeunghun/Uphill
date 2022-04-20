package com.uphill.web.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.MainBannerVO;
import com.uphill.web.dto.ReviewVO;
import com.uphill.web.service.home.HomeServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class Home implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		HomeServiceImpl homeService  = new HomeServiceImpl();
		List<List<?>> list = homeService.getMainPage();
		
		List<MainBannerVO> mainBannerList = (List<MainBannerVO>) list.get(0);
		List<ItemVO> bestSellerList =  (List<ItemVO>) list.get(1);
		List<ItemVO> bestItemList =  (List<ItemVO>) list.get(2);
		List<ReviewVO> recentReviewList = (List<ReviewVO>) list.get(3);
		
		request.setAttribute("mainBannerList", mainBannerList);
		request.setAttribute("bestSellerList", bestSellerList);
		request.setAttribute("bestItemList", bestItemList);
		request.setAttribute("recentReviewList", recentReviewList);		
		
		return new ViewResolver("/views/home/home.tiles");
	}
	
}
