package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DogCartAddService;
import vo.ActionForward;
import vo.Dog;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartAddService dogCartAddService = new DogCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Dog dog = dogCartAddService.getCartDog(id);
		
		dogCartAddService.addCart(request, dog);
		
		// 주의 : dogCartList.dog 요청 "장바구니 목록보기 요청"을 리다이렉트 방식으로 포워딩함
		return new ActionForward("dogCartList.dog", true);
	}

}
