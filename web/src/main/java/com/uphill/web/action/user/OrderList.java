package com.uphill.web.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.OrderListVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.user.UserService;
import com.uphill.web.service.user.UserServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class OrderList implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		UserVO userVO = null;		
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");
		} else {
			return new ViewResolver("/home/home", true);
		}
		
		UserService userService = new UserServiceImpl();
		
		OrderListVO orderListVO = userService.getOrderList(userVO.getUserIndex());
		if(orderListVO != null) {			
			request.setAttribute("orderList", orderListVO.getOrderList());
			request.setAttribute("orderItemList", orderListVO.getOrderItemInfoList());
		}
		
		return new ViewResolver("/views/user/orderList.tiles");
	}

}
