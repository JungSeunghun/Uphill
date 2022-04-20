package com.uphill.web.service.basket;

import java.util.List;

import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.BasketVO;

public interface BasketService {
	int insertBasket(BasketVO basketVO);
	List<BasketItemVO> getBasketItemList(int userIndex);
	int updateBasket(int userIndex, int basketIndex, int optionQty);
	int cancelBasket(int userIndex, int basketIndex);
	int cancelBasketList(int userIndex);
}
