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

import com.uphill.web.command.Command;
import com.uphill.web.command.IndexCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Command> commandMap = new HashMap<String, Command>();
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 초기화 하는 부분 깔끔하게 처리 어떻게 할지 고민 - 220324(정승훈)
		commandMap.put("/index.do", new IndexCommand());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 부분은 나중에 필터로 빼는게 좋은지 알아보기 - 220324(정승훈)
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = commandMap.get(page);
		String viewPage = command.run(request, response);
		
		if(viewPage != null && !viewPage.endsWith("do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	
}
