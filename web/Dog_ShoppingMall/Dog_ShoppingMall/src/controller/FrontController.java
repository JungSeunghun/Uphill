package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DogCartAddAction;
import action.DogCartListAction;
import action.DogCartQtyDownAction;
import action.DogCartQtyUpAction;
import action.DogCartRemoveAction;
import action.DogCartSearchAction;
import action.DogListAction;
import action.DogRegistAction;
import action.DogViewAction;
import vo.ActionForward;

// 확장자가 dog이면 무조건 FrontController로 이동하여 
@WebServlet("*.dog")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	// 이 서블릿으로 들어오는 모든 요청은 doProcess()를 호출하여 처리
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 반드시 적용
		
		// '프로젝트명 + 파일경로' (예)/Dog_ShoppingMall/dogList.dog
		String requestURI = request.getRequestURI();
		
		// '프로젝트명' (예)/Dog_ShoppingMall
		String contextPath = request.getContextPath();
		
		/*
		 * /Dog_ShoppingMall/dogList.dog - /Dog_ShoppingMall = /dogList.dog
		 */
		String command = requestURI.substring(contextPath.length()); // 부분문자열
		
		/*
		 * 컨트롤러에서 요청이 파악되면 해당 요청을 처리하는 각 Action클래스를 사용해서 요청 처리
		 * 각 요청에 해당하는 Action클래스 객체들을 다형성을 이용해서 동일한 타입인 Action으로 참조하기 위해
		 */
		Action action = null; // Action 부모 인터페이스 = Action을 구현한 객체
		ActionForward forward = null;
		
		/*
		 * 
		 */
		if(command.equals("/dogList.dog")) { // '개 상품목록보기'요청이면
			action = new DogListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/dogView.dog")) { // '특정 개 상품의 상세 정보 보기'요청이면
			action = new DogViewAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		else if(command.equals("/dogRegistForm.dog")) { // '새로운 개 상품 정보 등록 폼인 뷰페이지 보기'요청이면
			forward = new ActionForward("dogRegistForm.jsp", true); // 리다이렉트 방식:새요청, ※false로 해도 됨
		} 
		
		else if(command.equals("/dogRegist.dog")) { // '새로운 개 상품 정보 등록 처리하는'요청이면
			action = new DogRegistAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/dogCartAdd.dog")) { // '새로운 장바구니 항목을 추가하는 장바구니 담기'요청이면
			action = new DogCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/dogCartList.dog")) { // '장바구니 목록 보기'요청이면
			action = new DogCartListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/dogCartSearch.dog")) { // '최하가격~최고가격으로 장바구니 항목을 검색'요청이면
			action = new DogCartSearchAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/dogCartQtyUp.dog")) { // '장바구니 항목 수량 증가'요청이면
			action = new DogCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/dogCartQtyDown.dog")) { // '장바구니 항목 수량 증가'요청이면
			action = new DogCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/dogCartRemove.dog")) { // '장바구니 항목 수량 증가'요청이면
			action = new DogCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 포워딩
		 */
		if(forward != null) {
			if(forward.isRedirect()) { // 리다이렉트 방식 : 새요청, 기존 request 공유못함
				response.sendRedirect(forward.getPath());
			} else {
				// RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				// 기존 요청, 기존 응답 그대로 보내므로 request공유
				// dispatcher.forward(request, response);
				
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
	
}
