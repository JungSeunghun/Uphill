package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class DogCartSearchService {
	// 멤버변수
	
	// 기본 생성자
	
	// 메서드
	public List<Cart> getCartSearchList(int startMoney, int endMoney, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		// oldCartList: 검색 전
		List<Cart> oldCartList = (List<Cart>)session.getAttribute("cartList"); // 기본값이 null로 채워짐
		
		// searchCartList 검색 후
		List<Cart> searchCartList = new ArrayList<Cart>();
		for(int i = 0; i < oldCartList.size(); i++) {
			/*
			if(startMoney <= oldCartList.get(i).getPrice() && oldCartList.get(i).getPrice() <= endMoney ) {
				searchCartList.add(oldCartList.get(i));
			}
			*/
			Cart cart = oldCartList.get(i);
			if(startMoney <= cart.getPrice() && cart.getPrice() <= endMoney) {
				searchCartList.add(cart);
			}
		}
		return searchCartList;
	}
}
