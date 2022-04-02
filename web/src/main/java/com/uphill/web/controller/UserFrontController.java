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
import com.uphill.web.action.user.PurchasePageAction;
import com.uphill.web.action.user.BasketPageAction;
import com.uphill.web.action.user.LeaveAction;
import com.uphill.web.action.user.PurchaseAction;
import com.uphill.web.action.user.UpdateAction;
import com.uphill.web.common.ViewResolver;

@WebServlet("*.user")
public class UserFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/basketPage.user", new BasketPageAction());
		actionMap.put("/purchasePage.user", new PurchasePageAction());
		actionMap.put("/purchase.user", new PurchaseAction());
		actionMap.put("/update.user", new UpdateAction());
		actionMap.put("/leave.user", new LeaveAction());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 부분은 나중에 필터로 빼는게 좋은지 알아보기 - 220324(정승훈)
		request.setCharacterEncoding("UTF-8");
				
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		Action action = actionMap.get(command);
		
		ViewResolver viewResolver = null;
		
		if(action != null) {
			viewResolver = action.execute(request, response);
		} else {
			viewResolver = new ViewResolver(command, true);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewResolver.getPath());
		dispatcher.forward(request, response);
	}

}
