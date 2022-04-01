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
import com.uphill.web.action.home.HomeAction;
import com.uphill.web.common.ViewResolver;

@WebServlet("*.user")
public class UserFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
		
	@Override
	public void init(ServletConfig config) throws ServletException {
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
			// action이 없으면 command를 리다이렉트시킴
			viewResolver = new ViewResolver(command, true);
		}
		
		if(viewResolver.isRedirect()) { // 리다이렉트 방식 : 새요청, 기존 request 공유못함
			response.sendRedirect(viewResolver.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewResolver.getPath());
			dispatcher.forward(request, response);
		}
	}

}
