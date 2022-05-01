package com.uphill.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemListInfoVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.admin.AdminService;
import com.uphill.web.service.admin.AdminServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class Item implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO userVO = null;
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");			
		} else {
			return new ViewResolver("/account/login", true);
		}
		
		if(userVO.getGradeIndex() != 4) {
			return new ViewResolver("/home/home", true);
		}
		
		int count = 5;
		int pageCount = 5;
		int itemPage = 1;
		if(request.getParameter("page") != null) {
			itemPage = Integer.parseInt(request.getParameter("page"));			
		}
		
		AdminService adminService = new AdminServiceImpl();
		ItemListInfoVO itemListInfoVO = adminService.getItemListInfo(itemPage, count);
		int totalCount = itemListInfoVO.getTotalCount();		
		
		int itemEndPage = (int)Math.ceil((double)itemPage/pageCount) * pageCount;
		int itemStartPage = itemEndPage - pageCount + 1;
		int itemMaxPage = (int)Math.ceil((double)totalCount/count);
		if(itemEndPage > itemMaxPage) {
			itemEndPage = itemMaxPage;
		}
		
		request.setAttribute("itemList", itemListInfoVO.getItemList());
		request.setAttribute("itemPage", itemPage);
		request.setAttribute("itemStartPage", itemStartPage);
		request.setAttribute("itemEndPage", itemEndPage);
		request.setAttribute("itemMaxPage", itemMaxPage);
		
		return new ViewResolver("/views/admin/item.tiles");
	}

}
