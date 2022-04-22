package com.uphill.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.action.user.OrderList;
import com.uphill.web.action.user.UserInfo;
import com.uphill.web.action.user.BasketCancelAction;
import com.uphill.web.action.user.BasketCancelAllAction;
import com.uphill.web.action.user.BasketUpdateAction;
import com.uphill.web.action.user.Basket;
import com.uphill.web.action.user.BasketAction;
import com.uphill.web.action.user.UserLeaveAction;
import com.uphill.web.action.user.OrderAction;
import com.uphill.web.action.user.OrderBasketAction;
import com.uphill.web.action.user.Order;
import com.uphill.web.action.user.UserUpdateAction;
import com.uphill.web.viewresolver.ViewResolver;
import com.uphill.web.action.user.UserUpdate;

@WebServlet("/user/*")
public class UserFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/user/basket", new Basket());
		actionMap.put("/user/basket-action", new BasketAction());
		actionMap.put("/user/basket-update-action", new BasketUpdateAction());
		actionMap.put("/user/basket-cancel-action", new BasketCancelAction());
		actionMap.put("/user/basket-cancel-all-action", new BasketCancelAllAction());
		
		actionMap.put("/user/order", new Order());
		actionMap.put("/user/order-action", new OrderAction());
		actionMap.put("/user/order-basket-action", new OrderBasketAction());		
		actionMap.put("/user/order-list", new OrderList());
		
		actionMap.put("/user/user-info", new UserInfo());
		actionMap.put("/user/user-leave-action", new UserLeaveAction());
		
		actionMap.put("/user/user-update", new UserUpdate());
		actionMap.put("/user/user-update-action", new UserUpdateAction());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 부분은 나중에 필터로 빼는게 좋은지 알아보기 - 220324(정승훈)
		request.setCharacterEncoding("UTF-8");
		
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		Action action = actionMap.get(command);

		if(action != null) {
			ViewResolver viewResolver = action.execute(request, response);
			
			if(viewResolver.getData() != null) {
				response.getWriter().write(viewResolver.getData());
				return;
			}
			
			if(!viewResolver.getIsRedirect()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewResolver.getPath());
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(contextPath + viewResolver.getPath());
			}			
		}
	}

}
