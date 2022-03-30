package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartListService {
	// 1. 멤버변수
	
	// 2. 기본생성자
	
	// 주의 : DB 작업하는 것이 아니라 일련의 순서 1234할 필요없다.
	// 3. 메서드 : reqeuset로부터 session 영역을 얻어와 그 안의 cartList속성값을 반환
	public List<Cart> getCartList(HttpServletRequest request) { // 주의 : 매개값으로 반드시 request
		// request로부터 session 영역을 얻어와
		HttpSession session = request.getSession();
		List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");
		
		return cartList;
	}
}
