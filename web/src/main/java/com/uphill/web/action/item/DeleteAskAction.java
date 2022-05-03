package com.uphill.web.action.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class DeleteAskAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
			int askIndex = Integer.parseInt(request.getParameter("askIndex"));
					
			ItemService itemService = new ItemServiceImpl();
			itemService.deleteAsk(askIndex);
			
			return new ViewResolver("/item/item-info?id=" + itemIndex + "#itemAsk", true);
		} else {
			return new ViewResolver("/account/login", true);
		}		
	}

}
