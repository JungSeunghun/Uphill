package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogViewService;
import vo.ActionForward;
import vo.Dog;

public class DogViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		DogViewService dogViewService = new DogViewService();
		// 해당 개 상품의 '조회수 1증가' -> 'id로 조회한 개상품 정보를 Dog객체로 반환'
		int id = Integer.parseInt(request.getParameter("id"));
		Dog dog = dogViewService.getDogView(id);
		
		request.setAttribute("dog", dog);
		
		// 교재-753p 두 번째 그림의 하단 부분(doList.jsp) : 오늘 본 개 상품 목록 정보 
		Cookie todayImageCookie = new Cookie("today"+id, dog.getImage());
		todayImageCookie.setMaxAge(24*60*60); // 24시간(=하루) 설정
		response.addCookie(todayImageCookie); // 반드시, 응답에 쿠키 객체를 추가하여 보낸다.
		
		forward = new ActionForward("dogView.jsp", false);
		
		return forward;
	}

}
