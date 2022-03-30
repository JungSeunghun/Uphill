package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogCartListService;
import vo.ActionForward;
import vo.Cart;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartListService dogCartListService = new DogCartListService();
		List<Cart> cartList = dogCartListService.getCartList(request);
		
		/**
		 * (교재-758p)장바구니 목록에 존재하는 전체 상품에 대한 "총금액 계산"
		 */
		int totalMoney = 0; // 지불할 총 금액
		
		for(int i = 0; i < cartList.size(); i++) {
			Cart cart = cartList.get(i);
			totalMoney += cart.getPrice() * cart.getQty();
		}

		request.setAttribute("cartList", cartList);
		request.setAttribute("totalMoney", totalMoney);
		
		return new ActionForward("dogCartList.jsp", false);
	}

}
