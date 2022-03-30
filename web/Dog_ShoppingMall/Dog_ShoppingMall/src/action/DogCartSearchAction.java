package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogCartSearchService;
import vo.ActionForward;
import vo.Cart;

public class DogCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int startMoney = 0;
		if(request.getParameter("startMoney") != null && !request.getParameter("startMoney").equals("")) {
			startMoney = Integer.parseInt(request.getParameter("startMoney"));			
		}
		int endMoney = 0;
		if(request.getParameter("endMoney") != null  && !request.getParameter("endMoney").equals("")) {
			endMoney = Integer.parseInt(request.getParameter("endMoney"));			
		}
		
		if(startMoney != 0 && endMoney != 0) {
			DogCartSearchService dogCartSearchService = new DogCartSearchService();
			List<Cart> cartList = dogCartSearchService.getCartSearchList(startMoney, endMoney, request);
			
			int totalMoney = 0; // 지불할 총 금액
			
			for(int i = 0; i < cartList.size(); i++) {
				Cart cart = cartList.get(i);
				totalMoney += cart.getPrice() * cart.getQty();
			}
			
			request.setAttribute("cartList", cartList);
			request.setAttribute("startMoney", startMoney); // "=최하=" 대신 화면에 표시될 속성값
			request.setAttribute("endMoney", endMoney); // "=최고=" 대신 화면에 표시될 속성값
			request.setAttribute("totalMoney", totalMoney);
			
			return new ActionForward("dogCartList.jsp", false);
		}
		
		return new ActionForward("dogCartList.dog", true);
	}

}
