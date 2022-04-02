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
import com.uphill.web.action.home.CustomerPageAction;
import com.uphill.web.action.home.HomeAction;
import com.uphill.web.action.home.IntroPageAction;
import com.uphill.web.action.home.JoinPageAction;
import com.uphill.web.action.home.LoginPageAction;
import com.uphill.web.action.home.LogoutAction;
import com.uphill.web.action.home.MyPageAction;
import com.uphill.web.common.ViewResolver;

@WebServlet("*.home")
public class HomeFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/home.home", new HomeAction());
		actionMap.put("/introPage.home", new IntroPageAction());
		actionMap.put("/customerPage.home", new CustomerPageAction());
		actionMap.put("/loginPage.home", new LoginPageAction());
		actionMap.put("/joinPage.home", new JoinPageAction());
		actionMap.put("/myPage.home", new MyPageAction());
		actionMap.put("/logout.home", new LogoutAction());
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
