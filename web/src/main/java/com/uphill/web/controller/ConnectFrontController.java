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
import com.uphill.web.action.connect.FindIdAction;
import com.uphill.web.action.connect.FindIdPageAction;
import com.uphill.web.action.connect.FindPasswordAction;
import com.uphill.web.action.connect.FindPasswordPageAction;
import com.uphill.web.action.connect.FindSelectPageAction;
import com.uphill.web.action.connect.Join1PageAction;
import com.uphill.web.action.connect.Join2PageAction;
import com.uphill.web.action.connect.JoinAction;
import com.uphill.web.action.connect.LoginAction;
import com.uphill.web.action.connect.LoginPageAction;
import com.uphill.web.action.connect.LogoutAction;

@WebServlet("*.connect")
public class ConnectFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/loginPage.home", new LoginPageAction());
		actionMap.put("/login.connect", new LoginAction());
		actionMap.put("/logout.connect", new LogoutAction());
		
		actionMap.put("/join1Page.connect", new Join1PageAction());
		actionMap.put("/join2Page.connect", new Join2PageAction());
		actionMap.put("/join.connect", new JoinAction());
		
		actionMap.put("/findSelectPage.connect", new FindSelectPageAction());
		actionMap.put("/findIdPage.connect", new FindIdPageAction());
		actionMap.put("/findPasswordPage.connect", new FindPasswordPageAction());
		actionMap.put("/findId.connect", new FindIdAction());
		actionMap.put("/findPassword.connect", new FindPasswordAction());
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
