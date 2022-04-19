package com.uphill.web.service.user;

import java.util.List;

import com.uphill.web.dao.BasketDAO;
import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.BasketVO;

public class BasketService {
	public void insertBasket(BasketVO basketVO) {
		BasketDAO basketDAO = new BasketDAO();
		basketDAO.insertBasket(basketVO);
	}

	public List<BasketItemVO> getBasketItemList(int userIndex) {
		BasketDAO basketDAO = new BasketDAO();
		return basketDAO.selectBasketItemList(userIndex);
	}

	public void updateBasket(int userIndex, int basketIndex, int optionQty) {
		BasketDAO basketDAO = new BasketDAO();
		basketDAO.updateBasket(userIndex, basketIndex, optionQty);
	}

	public void cancelBasket(int userIndex, int basketIndex) {
		BasketDAO basketDAO = new BasketDAO();
		basketDAO.deleteBasket(userIndex, basketIndex);
	}

	public void cancelBasketList(int userIndex) {
		BasketDAO basketDAO = new BasketDAO();
		basketDAO.deleteBasketList(userIndex);
	}
}
