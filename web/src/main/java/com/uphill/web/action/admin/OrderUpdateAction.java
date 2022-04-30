package com.uphill.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.admin.AdminService;
import com.uphill.web.service.admin.AdminServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class OrderUpdateAction implements Action {

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
		
		int orderIndex = Integer.parseInt(request.getParameter("orderIndex"));
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		
		AdminService adminService = new AdminServiceImpl();
		adminService.updateOrder(orderState, orderIndex);
		
		return new ViewResolver("/admin/order-info?orderIndex=" + orderIndex, true);
	}

}
