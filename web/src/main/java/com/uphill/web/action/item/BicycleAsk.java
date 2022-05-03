package com.uphill.web.action.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.viewresolver.ViewResolver;

public class BicycleAsk implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			int itemIndex = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("itemIndex", itemIndex);
			
			if(request.getParameter("askIndex") != null) {
				int askIndex = Integer.parseInt(request.getParameter("askIndex"));
				int askGroupIndex = Integer.parseInt(request.getParameter("askGroupIndex"));
				int askGroupLevel = Integer.parseInt(request.getParameter("askGroupLevel"));
				
				request.setAttribute("askIndex", askIndex);
				request.setAttribute("askGroupIndex", askGroupIndex);
				request.setAttribute("askGroupLevel", askGroupLevel);
			}
			
			return new ViewResolver("/views/item/bicycleAsk.tiles");
		} else {
			return new ViewResolver("/account/login", true);
		}
		
	}

}
