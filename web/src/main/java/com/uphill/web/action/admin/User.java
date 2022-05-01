package com.uphill.web.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.UserListInfoVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.admin.AdminService;
import com.uphill.web.service.admin.AdminServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class User implements Action {

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
		int userPage = 1;
		if(request.getParameter("page") != null) {
			userPage = Integer.parseInt(request.getParameter("page"));			
		}
		
		AdminService adminService = new AdminServiceImpl();
		UserListInfoVO userListInfoVO = adminService.getUserListInfo(userPage, count);
		int totalCount = userListInfoVO.getTotalCount();		
		
		int userEndPage = (int)Math.ceil((double)userPage/pageCount) * pageCount;
		int userStartPage = userEndPage - pageCount + 1 ;
		int userMaxPage = (int)Math.ceil((double)totalCount/count);
		if(userEndPage > userMaxPage) {
			userEndPage = userMaxPage;
		}
		
		request.setAttribute("userList", userListInfoVO.getUserList());
		request.setAttribute("userPage", userPage);
		request.setAttribute("userStartPage", userStartPage);
		request.setAttribute("userEndPage", userEndPage);
		request.setAttribute("userMaxPage", userMaxPage);		
		
		return new ViewResolver("/views/admin/user.tiles");
	}

}
