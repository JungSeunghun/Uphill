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
import com.uphill.web.action.user.UserInfoPageAction;
import com.uphill.web.action.user.BasketCancelAction;
import com.uphill.web.action.user.BasketCancelAllAction;
import com.uphill.web.action.user.BasketPageAction;
import com.uphill.web.action.user.UserLeaveAction;
import com.uphill.web.action.user.OrderAction;
import com.uphill.web.action.user.OrderPageAction;
import com.uphill.web.action.user.UserUpdateAction;
import com.uphill.web.action.user.UserUpdatePageAction;

@WebServlet("*.user")
public class UserFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/basketPage.user", new BasketPageAction());
		actionMap.put("/basketCancel.user", new BasketCancelAction());
		actionMap.put("/basketCancelAll.user", new BasketCancelAllAction());
		
		actionMap.put("/orderPage.user", new OrderPageAction());
		actionMap.put("/order.user", new OrderAction());
		
		actionMap.put("/purchasePage.user", new PurchasePageAction());
		
		actionMap.put("/userInfoPage.user", new UserInfoPageAction());
		actionMap.put("/userLeave.user", new UserLeaveAction());
		
		actionMap.put("/userUpdatePage.user", new UserUpdatePageAction());
		actionMap.put("/userUpdate.user", new UserUpdateAction());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 부분은 나중에 필터로 빼는게 좋은지 알아보기 - 220324(정승훈)
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		Action action = actionMap.get(command);
		
		String path = "";
		
		if(action != null) {
			path = action.execute(request, response);	
		}
		
		path = path + ".tiles";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
