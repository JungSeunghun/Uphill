package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.DogDAO;
import vo.Cart;
import vo.Dog;

public class DogCartAddService {
	// 1. 멤버변수
	
	// 2. 기본생성자
	
	// 3. 메서드	
	// 3-1. 매개값으로 전달받은 id로 조회한 개 상품 정보 하나를 Dog객체로 반환
	public Dog getCartDog(int id) {
		// 1. 커넥션 풀에서 Connection객체 얻어와
		Connection connection = getConnection();
		
		// 2. 싱글톤 패턴으로 DogDao객체 생성
		DogDAO dogDAO = DogDAO.getInstance();
				
		// 3. DB작업에 사용될 Connection객체를 DogDAO의 멤버변수에  전달하여 DB연결하여 작업하도록 서비스 해줌
		dogDAO.setConnection(connection);
		
		/** DogDAO의 해당 메서드를 호출하여 처리 **/
		// 'id로 조회한 개 상품 정보를 Dog객체로 변환'
		Dog dog = dogDAO.selectDog(id);
		
		/** 
		 * (insert,update,delete) 성공하면 commit, 실패하면 rollback
		 * (select)제외 
		 */
		
		// 4. r객체
		close(connection);
		
		return dog;
	}
	
	/*
	 *  3-2. 위에서 얻어온 Dog객체를 장바구니 항목에 추가
	 *  ★★장바구니 항목을 유지할 수 있도록 session영역에 장바구니 항목을 추가
	 *  매개값으로 "request 객체"와 장바구니에 추가할 개 정보객체를 전송받아야 함
	 */
	public void addCart(HttpServletRequest request, Dog dog) {
		HttpSession session = request.getSession(); // 새로운 세션을 만들거나 기존의 세션영역을 가져옴
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		
		// 장바구니 담기가 처음이라 session영역에 없으면 
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true; // 지금 장바구니 담는 개 상품이 새로 추가되는 개 상품인지를 저장할 변수
		
		// ★★순서 중요
		// 기존에 장바구니 항목(cartList)이 존재하면 같은 개 상품을 찾아서 수량을 1증가
		for(int i = 0; i < cartList.size(); i++) {
			// 찾는 기준 : 개 품종 = "개 상품명"(kind)
			if(cartList.get(i).getKind().equals(dog.getKind())) {
				isNewCart = false; // 장바구니 항목에 존재하면 false로 만들어 2.부분 실행막아야 함
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
			}
		}
		
		if(isNewCart == true) {
			Cart cart = new Cart(); // 기본값으로 채워진 Cart객체
			cart.setImage(dog.getImage());
			cart.setKind(dog.getKind());
			cart.setPrice(dog.getPrice());
			cart.setQty(1); // 수량은 처음이므로 1로 셋팅
			
			cartList.add(cart);
		}
	}
	
}
