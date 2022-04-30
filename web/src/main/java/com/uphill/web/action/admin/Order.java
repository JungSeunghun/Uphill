package com.uphill.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.OrderListInfoVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.admin.AdminService;
import com.uphill.web.service.admin.AdminServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class Order implements Action {

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
		int orderPage = 1;
		if(request.getParameter("page") != null) {
			orderPage = Integer.parseInt(request.getParameter("page"));			
		}
		
		AdminService adminService = new AdminServiceImpl();
		OrderListInfoVO orderListInfoVO = adminService.getOrderList(orderPage, count);
		int totalCount = orderListInfoVO.getTotalCount();		
		
		int orderEndPage = (int)Math.ceil((double)totalCount/pageCount) * pageCount;
		int orderStartPage = orderEndPage - pageCount + 1 ;
		int orderMaxPage = (int)Math.ceil((double)totalCount/count);
		if(orderEndPage > orderMaxPage) {
			orderEndPage = orderMaxPage;
		}
		
		request.setAttribute("orderList", orderListInfoVO.getOrderList());
		request.setAttribute("orderPage", orderPage);
		request.setAttribute("orderStartPage", orderStartPage);
		request.setAttribute("orderEndPage", orderEndPage);
		request.setAttribute("orderMaxPage", orderMaxPage);
		
		return new ViewResolver("/views/admin/order.tiles");
	}

}
