package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {
	// 추상메서드 : 반드시 자식 클래스에서 재정의해야함
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
