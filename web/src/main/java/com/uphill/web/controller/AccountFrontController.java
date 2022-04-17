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
import com.uphill.web.action.account.FindIdAction;
import com.uphill.web.action.account.CheckDuplicateEmailAction;
import com.uphill.web.action.account.CheckDuplicateIdAction;
import com.uphill.web.action.account.CheckSecureCodeAction;
import com.uphill.web.action.account.FindId;
import com.uphill.web.action.account.FindPasswordAction;
import com.uphill.web.action.account.FindPassword;
import com.uphill.web.action.account.FindSelect;
import com.uphill.web.action.account.Join1;
import com.uphill.web.action.account.Join2;
import com.uphill.web.action.account.JoinAction;
import com.uphill.web.action.account.LoginAction;
import com.uphill.web.action.account.Login;
import com.uphill.web.action.account.LogoutAction;
import com.uphill.web.viewresolver.ViewResolver;

@WebServlet("/account/*")
public class AccountFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/account/login", new Login());
		actionMap.put("/account/login-action", new LoginAction());
		actionMap.put("/account/logout-action", new LogoutAction());
		
		actionMap.put("/account/join1", new Join1());
		actionMap.put("/account/join2", new Join2());
		actionMap.put("/account/check-duplicate-id-action", new CheckDuplicateIdAction());
		actionMap.put("/account/check-duplicate-email-action", new CheckDuplicateEmailAction());
		actionMap.put("/account/check-secure-code-action", new CheckSecureCodeAction());
		actionMap.put("/account/join-action", new JoinAction());
		
		actionMap.put("/account/find-select", new FindSelect());
		
		actionMap.put("/account/find-id", new FindId());
		actionMap.put("/account/find-id-action", new FindIdAction());
		
		actionMap.put("/account/find-password", new FindPassword());
		actionMap.put("/account/find-password-action", new FindPasswordAction());
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
