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
import com.uphill.web.action.admin.Item;
import com.uphill.web.action.admin.ItemInfo;
import com.uphill.web.action.admin.Order;
import com.uphill.web.action.admin.OrderInfo;
import com.uphill.web.action.admin.OrderUpdateAction;
import com.uphill.web.action.admin.User;
import com.uphill.web.action.admin.UserDeleteAction;
import com.uphill.web.action.admin.UserInfo;
import com.uphill.web.viewresolver.ViewResolver;

@WebServlet("/admin/*")
public class AdminFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/admin/user", new User());
		actionMap.put("/admin/user-info", new UserInfo());
		actionMap.put("/admin/user-delete-action", new UserDeleteAction());
		
		actionMap.put("/admin/order", new Order());
		actionMap.put("/admin/order-info", new OrderInfo());
		actionMap.put("/admin/order-update-action", new OrderUpdateAction());
		
		actionMap.put("/admin/item", new Item());
		actionMap.put("/admin/item-info", new ItemInfo());		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 부분은 나중에 필터로 빼는게 좋은지 알아보기 - 220324(정승훈)
		request.setCharacterEncoding("UTF-8");
		
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
