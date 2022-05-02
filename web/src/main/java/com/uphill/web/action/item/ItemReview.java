package com.uphill.web.action.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemReview implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			int itemIndex = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("itemIndex", itemIndex);
			
			return new ViewResolver("/views/item/itemReview.tiles");			
		} else {
			return new ViewResolver("/account/login", true);
		}
	}

}
