package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartQtyUpService {
	// 멤버변수
	
	// 기본생성자
	
	// 메서드
	public void upCartQty(String kind, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");
		// 장바구니 담기가 처음이라 session영역에 없으면 
		if(cartList == null) {
			return;
		}
		/* 장바구니 항목 객체에서 수량을 증가시킬 대상을 kind값으로 비교햐여 검색한 후 해당 객체의 수량 증가 */
		for(int i = 0; i < cartList.size(); i++) {
			Cart cart = cartList.get(i);
			if(cart.getKind().equals(kind)) {
				cart.setQty(cart.getQty() + 1); // 수량 1 증가 후
				break; // 찾았으면 바로 반복문 빠져나감
			}
		}
		
	}
	
}
