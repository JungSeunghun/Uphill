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
import com.uphill.web.action.item.Ask;
import com.uphill.web.action.item.ItemList;
import com.uphill.web.action.item.Review;

@WebServlet(urlPatterns = {"/bicycle/*","/item/*"})
public class ItemFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/bicycle/bicycle", new ItemList());
		actionMap.put("/bicycle/mtb", new ItemList());
		actionMap.put("/bicycle/road", new ItemList());
		actionMap.put("/bicycle/minivelo", new ItemList());
		
		actionMap.put("/item/item", new ItemList());
		actionMap.put("/item/helmet", new ItemList());
		actionMap.put("/item/light", new ItemList());
		actionMap.put("/item/lock", new ItemList());

		actionMap.put("/bicycle/review", new Review());
		actionMap.put("/item/review", new Review());
		actionMap.put("/bicycle/ask", new Ask());
		actionMap.put("/item/ask", new Ask());
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
			String path = action.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(command);
		}
	}

}
