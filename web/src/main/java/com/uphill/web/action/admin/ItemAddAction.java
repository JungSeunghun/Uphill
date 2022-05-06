package com.uphill.web.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.uphill.web.action.Action;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.admin.AdminService;
import com.uphill.web.service.admin.AdminServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class ItemAddAction implements Action {

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
		String uploadPath = context.getRealPath("/images/items");
		File dir = new File(uploadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		int size = 10 * 1024 * 1024;
		
		ItemVO itemVO = null;
		List<ItemOptionVO> itemOptionList = new ArrayList<ItemOptionVO>();
 		try {
			MultipartRequest multipartRequest = new MultipartRequest(
					request,
					uploadPath,
					size,
					"UTF-8",
					new DefaultFileRenamePolicy()
					);			
			String itemName = multipartRequest.getParameter("itemName");
			int itemCategoryIndex = Integer.parseInt(multipartRequest.getParameter("itemCategoryIndex"));
			String itemCategoryName = null;
			if(itemCategoryIndex == 1) {
				itemCategoryName = "자전거";
			} else if (itemCategoryIndex == 2) {
				itemCategoryName = "헬멧";
			} else if (itemCategoryIndex == 3) {
				itemCategoryName = "라이트";
			} else if (itemCategoryIndex == 4) {
				itemCategoryName = "자물쇠";
			}
			int itemSubcategoryIndex = 0;
			String itemSubcategoryName = null;
			if(multipartRequest.getParameter("itemSubcategoryIndex") != null) {
				itemSubcategoryIndex = Integer.parseInt(multipartRequest.getParameter("itemSubcategoryIndex"));
				itemSubcategoryName = null;
				if(itemSubcategoryIndex == 1) {
					itemSubcategoryName = "MTB";
				} else if (itemSubcategoryIndex == 2) {
					itemSubcategoryName = "Road";
				} else if (itemSubcategoryIndex == 3) {
					itemSubcategoryName = "Minivelo";
				}
			}
			int itemPrice = Integer.parseInt(multipartRequest.getParameter("itemPrice"));
			int itemDiscountPrice = Integer.parseInt(multipartRequest.getParameter("itemDiscountPrice"));
			int itemTotalQty = Integer.parseInt(multipartRequest.getParameter("itemTotalQty"));
			
			Enumeration<?> fileNames = multipartRequest.getFileNames();
			String fileName = "";
			String fileSystemName = "";
			if(fileNames.hasMoreElements()) {
				fileName = (String)fileNames.nextElement();
				fileSystemName = multipartRequest.getFilesystemName(fileName);
			}
			
			itemVO = new ItemVO(itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, fileSystemName, itemPrice, itemDiscountPrice, itemTotalQty);
			
			String[] itemOptionNameArray = multipartRequest.getParameterValues("itemOptionName");
			String[] itemOptionContentArray = multipartRequest.getParameterValues("itemOptionContent");
			String[] itemOptionPriceArray = multipartRequest.getParameterValues("itemOptionPrice");
			String[] itemOptionQtyArray = multipartRequest.getParameterValues("itemOptionQty");
			for(int i = 0; i < itemOptionNameArray.length; i++) {
				itemOptionList.add(new ItemOptionVO(itemOptionNameArray[i], itemOptionContentArray[i], Integer.parseInt(itemOptionPriceArray[i]), Integer.parseInt(itemOptionQtyArray[i])));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
 		AdminService adminService = new AdminServiceImpl();
 		adminService.insertItem(itemVO, itemOptionList);
		
		return new ViewResolver("/admin/item", true);
	}

}
