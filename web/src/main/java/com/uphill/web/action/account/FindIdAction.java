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
		
		String userId = userIdFindService.userIdFindService("userEnterId");
		
		if( userId == null) {
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.print("<script>");
			out.print("alert('존재하지 않는 계정입니다')");
			out.print("history.back()");
			out.print("</script>");
		}else {
			
			request.setAttribute("", );
		} 
		
				
					
		return new ViewResolver("/views/account/findIdResult.tiles");
	}

}
