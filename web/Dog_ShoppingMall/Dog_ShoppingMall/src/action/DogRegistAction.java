package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.DogRegistService;
import vo.ActionForward;
import vo.Dog;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 파일을 업로드 할 서버상의 디렉토리 경로
		String saveFolder = "/images";
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath(saveFolder);
		
		// 한번에 올릴 수있는 최대용량 5M로 제한
		int maxSize = 5 * 1024 *1024;
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Dog dog = new Dog(0, // 0인 이유? insert할 때 id값을 dog_seq.nextval로 자동 1증가
				multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price")), 
				multi.getFilesystemName("image"), 
				multi.getParameter("country"), 
				Integer.parseInt(multi.getParameter("height")), 
				Integer.parseInt(multi.getParameter("weight")), 
				multi.getParameter("content"), 
				0); // 조회수 : 0부터 시작
		
		DogRegistService dogRegistService = new DogRegistService();
		// 새로운 개 정보(dog)를 dog테이블에 insert함
		boolean isRegistSuccess = dogRegistService.registDog(dog);
		
		if(isRegistSuccess) {
			forward = new ActionForward("dogList.dog", true); // 리다이렉트 방식(재요청)
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter(); // 화면에 출력
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
