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
import com.uphill.web.action.item.BicycleList;
import com.uphill.web.action.item.HelmetList;
import com.uphill.web.action.item.ItemInfo;
import com.uphill.web.action.item.ItemList;
import com.uphill.web.action.item.LightList;
import com.uphill.web.action.item.LockList;
import com.uphill.web.action.item.MiniveloList;
import com.uphill.web.action.item.MtbList;
import com.uphill.web.action.item.Review;
import com.uphill.web.action.item.RoadList;
import com.uphill.web.viewresolver.ViewResolver;

@WebServlet("/item/*")
public class ItemFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Action> actionMap = new HashMap<String, Action>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap.put("/item/bicycle", new BicycleList());
		actionMap.put("/item/mtb", new MtbList());
		actionMap.put("/item/road", new RoadList());
		actionMap.put("/item/minivelo", new MiniveloList());
		
		actionMap.put("/item/item", new ItemList());
		actionMap.put("/item/helmet", new HelmetList());
		actionMap.put("/item/light", new LightList());
		actionMap.put("/item/lock", new LockList());

		actionMap.put("/item/item-info", new ItemInfo());
		actionMap.put("/item/review", new Review());
		actionMap.put("/item/ask", new Ask());
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
