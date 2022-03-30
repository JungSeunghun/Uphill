/*
 * 컨트롤러에서 요청이 파악되면 해당 요청을 처리하는 각 Action클래스를 사용해서 요청 처리
 * 각 요청에 해당하는 Action클래스 객체들을 다형성을 이용해서 동일한 타입인 Action으로 참조하기 위해
 */
package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogListService;
import vo.ActionForward;
import vo.Dog;

public class DogListAction implements Action {
	
	// 기본생성자
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = null;
		
		// 교재-753p - 두 번째 그림
		
		// [위쪽] 개 상품 목록보기 요청을 처리하는 서비스 객체 생성 후
		DogListService dogListService = new DogListService();
		List<Dog> dogList = dogListService.getDogList();
		
		// [아래쪽] 오늘 본 개상품의 이미지를 저장할 ArrayList 객체 생성한 후
		List<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null) {
			for(int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}

		request.setAttribute("dogList", dogList);
		request.setAttribute("todayImageList", todayImageList);
		
		forward = new ActionForward("dogList.jsp", false); // 디스패치 방식(기존요청 그대로 전달하여 공유)
		
		return forward;
	}

}
