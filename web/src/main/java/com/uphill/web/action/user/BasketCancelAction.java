package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.basket.BasketService;
import com.uphill.web.service.basket.BasketServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class BasketCancelAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO userVO = null;
		
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");
		} else {
			return new ViewResolver("/account/login", true);
		}
		
		int basketIndex = Integer.parseInt(request.getParameter("basketIndex"));
		int userIndex = userVO.getUserIndex();
		
		BasketService basketService = new BasketServiceImpl();
		basketService.cancelBasket(userIndex, basketIndex);
		
		return new ViewResolver("/user/basket", true);
		
	}

}
