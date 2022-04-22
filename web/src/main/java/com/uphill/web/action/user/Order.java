package com.uphill.web.action.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uphill.web.action.Action;
import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.basket.BasketService;
import com.uphill.web.service.basket.BasketServiceImpl;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class Order implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
			
		HttpSession session = request.getSession();
		UserVO userVO = null;
		if(session.getAttribute("userVO") != null && session.getAttribute("userVO") instanceof UserVO) {
			userVO = (UserVO)session.getAttribute("userVO");
		} else {
			return new ViewResolver("/home/home", true);
		}
		
		if(request.getParameter("itemIndex") != null) {
			int userIndex = Integer.parseInt(request.getParameter("userIndex"));
			int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
			String optionName = request.getParameter("optionName");
			int optionQty = Integer.parseInt(request.getParameter("optionQty"));
			int optionPrice = Integer.parseInt(request.getParameter("optionPrice"));
			
			ItemService itemService = new ItemServiceImpl();
			ItemVO itemVO = itemService.getItem(itemIndex);
			
			int itemCategoryIndex = itemVO.getItemCategoryIndex();
			String itemCategoryName = itemVO.getItemCategoryName();
			int itemSubcategoryIndex = itemVO.getItemSubcategoryIndex(); 
			String itemSubcategoryName = itemVO.getItemCategoryName();
			String itemName = itemVO.getItemName();
			String itemImage = itemVO.getItemImage();
			float starRating = itemVO.getStarRating();
			int itemPrice = itemVO.getItemPrice();
			int itemDiscountPrice = itemVO.getItemDiscountPrice();
			int itemTotalQty = itemVO.getItemTotalQty();
			
			List<BasketItemVO> orderItemList = new ArrayList<BasketItemVO>();
			BasketItemVO basketItemVO = new BasketItemVO(userIndex, itemIndex, optionName, optionQty, optionPrice, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty);
			orderItemList.add(basketItemVO);			
			request.setAttribute("orderItemList", orderItemList);
			request.setAttribute("isBasket", false);
		} else {
			BasketService basketService = new BasketServiceImpl();
			List<BasketItemVO> orderItemList = basketService.getBasketItemList(userVO.getUserIndex());
			request.setAttribute("orderItemList", orderItemList);
			request.setAttribute("isBasket", true);
		}		
		
		return new ViewResolver("/views/user/order.tiles");
	}

}
