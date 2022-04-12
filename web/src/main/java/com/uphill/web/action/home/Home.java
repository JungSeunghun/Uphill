package com.uphill.web.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.item.ItemVO;
import com.uphill.web.service.home.HomeService;
import com.uphill.web.viewresolver.ViewResolver;

public class Home implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		HomeService homeService  = new HomeService();
		List<ItemVO> bestSeller =  homeService.getBestSellerList(1, 3); // category=1, count=3
		List<ItemVO> bestItem =  homeService.getBestItemList(3); // count=3
		
		request.setAttribute("bestSeller", bestSeller);
		request.setAttribute("bestItem", bestItem);
				
		return new ViewResolver("/views/home/home.tiles");
	}
	
}
