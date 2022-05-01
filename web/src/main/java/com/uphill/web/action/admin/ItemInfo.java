package com.uphill.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemInfoVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.admin.AdminService;
import com.uphill.web.service.admin.AdminServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemInfo implements Action {

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
		
		int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
		
		AdminService adminService = new AdminServiceImpl();
		ItemInfoVO itemInfoVO = adminService.getItemInfo(itemIndex);
		
		request.setAttribute("itemVO", itemInfoVO.getItemVO());
		request.setAttribute("itemOptionList", itemInfoVO.getItemOptionList());
		
		return new ViewResolver("/views/admin/itemInfo.tiles");
	}

}
