package com.uphill.web.service.basket;

import java.util.List;
import java.util.Map;

import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.BasketVO;

public interface BasketMapper {
	int insertBasket(BasketVO basketVO);
	List<BasketItemVO> selectBasketItemList(int userIndex);
	int updateBasket(Map<String, Integer> map);
	int deleteBasket(Map<String, Integer> map);
	int deleteBasketList(int userIndex);
}
