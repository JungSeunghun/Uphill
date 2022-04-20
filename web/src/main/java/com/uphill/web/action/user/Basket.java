package com.uphill.web.action.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.basket.BasketService;
import com.uphill.web.service.basket.BasketServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class Basket implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO userVO = null;
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");			
		} else {
			return new ViewResolver("/account/login", true);
		}
		
		BasketService basketService = new BasketServiceImpl();
		List<BasketItemVO> basketItemList =  basketService.getBasketItemList(userVO.getUserIndex());
		
		request.setAttribute("basketItemList", basketItemList);
		
		return new ViewResolver("/views/user/basket.tiles");
	}

}
