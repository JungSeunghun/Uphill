package com.uphill.web.action.account;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uphill.web.action.Action;
import com.uphill.web.action.user.UserInfo;
import com.uphill.web.service.account.UserIdFindService;
import com.uphill.web.viewresolver.ViewResolver;

public class FindIdAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		UserIdFindService userIdFindService = new UserIdFindService();
		
		String userId = userIdFindService.userIdFindService(email);
		
		if( userId == null) {
			
		}else {
			
		} 
		
				
					
		return new ViewResolver("/views/account/findIdResult.tiles");
	}

}
