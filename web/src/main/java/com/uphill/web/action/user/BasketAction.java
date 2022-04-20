package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.dto.BasketVO;
import com.uphill.web.service.basket.BasketService;
import com.uphill.web.service.basket.BasketServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class BasketAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
				
		int userIndex = Integer.parseInt(request.getParameter("userIndex"));
		int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
		String optionName = request.getParameter("optionName");
		int optionQty = Integer.parseInt(request.getParameter("optionQty"));
		int optionPrice = Integer.parseInt(request.getParameter("optionPrice"));
		
		BasketVO basketVO = new BasketVO(userIndex, itemIndex, optionName, optionQty, optionPrice);
		
		BasketService basketService = new BasketServiceImpl();
		basketService.insertBasket(basketVO);
		
		return new ViewResolver("/user/basket", true);
	}

}
