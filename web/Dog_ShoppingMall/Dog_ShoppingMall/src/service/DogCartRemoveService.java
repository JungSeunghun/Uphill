package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;
import vo.Dog;

public class DogCartRemoveService {
	
	public void removeCart(HttpServletRequest request, String[] kinds) {
		HttpSession session = request.getSession(); // 새로운 세션을 만들거나 기존의 세션영역을 가져옴
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		
		// 장바구니 담기가 처음이라 session영역에 없으면 
		if(cartList == null) {
			return;
		}
		
		for(int i = 0; i < kinds.length; i++) {
			for(int j = 0; j < cartList.size(); j++) {
				Cart cart = cartList.get(j);
				if(cart.getKind().equals(kinds[i])) {
					cartList.remove(j); // 장바구니 목록에서 제거한 후
					break; // 안쪽 반복문을 빠져나감(kind가 각 1가지씩만 있을 때)
				}
			}
		}
	}
	
}
