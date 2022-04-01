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
import com.uphill.web.common.ActionForward;

@WebServlet("*.up")
public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
		
	private void initHomeAction() {
		actionMap.put("/home.up", new HomeAction());
	}
	
	private void initItemAction() {
		
	}
	
	// 태경씨
	private void initLoginAction() {
		
	}
	
	// 동준씨
	private void initUserAction() {
		
	}
	
	private void initCommunityAction() {
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		initHomeAction();
		initItemAction();
		initLoginAction();
		initUserAction();
		initCommunityAction();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 부분은 나중에 필터로 빼는게 좋은지 알아보기 - 220324(정승훈)
		request.setCharacterEncoding("UTF-8");
				
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		Action action = actionMap.get(command);
		
		if(action == null) {
			return;
		}
		
		ActionForward forward = action.execute(request, response);
		
		if(forward.isRedirect()) { // 리다이렉트 방식 : 새요청, 기존 request 공유못함
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

}
