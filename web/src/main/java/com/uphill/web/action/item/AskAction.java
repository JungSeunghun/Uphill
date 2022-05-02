package com.uphill.web.action.item;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.uphill.web.action.Action;
import com.uphill.web.dto.AskVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class AskAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserVO userVO = null;
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");			
		} else {
			return new ViewResolver("/account/login", true);
		}
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/images/asks");
		File dir = new File(uploadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		int size = 10 * 1024 * 1024;
		
		int itemIndex = 0;
		String userId = userVO.getUserId();
		String title = "";
		String content = "";
		String fileName = "";
		String fileSystemName = "";
		
		try {
			MultipartRequest multipartRequest = new MultipartRequest(
					request,
					uploadPath,
					size,
					"UTF-8",
					new DefaultFileRenamePolicy()
					);			
			itemIndex = Integer.parseInt(multipartRequest.getParameter("id"));
			title = multipartRequest.getParameter("title");
			content = multipartRequest.getParameter("content");
			Enumeration<?> fileNames = multipartRequest.getFileNames();
			
			if(fileNames.hasMoreElements()) {
				fileName = (String)fileNames.nextElement();
				fileSystemName = multipartRequest.getFilesystemName(fileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AskVO askVO = new AskVO(itemIndex, userId, title, content, fileSystemName);
		
		ItemService itemService = new ItemServiceImpl();
		itemService.insertAsk(askVO);
				
		return new ViewResolver("/item/item-info?id=" + itemIndex + "#itemAsk", true);
	}

}
