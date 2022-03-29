package com.uphill.web.data.basket.service;

import java.util.List;

import com.uphill.web.data.basket.dto.BasketVO;

public interface BasketService {
	List<BasketVO> getAllBaskets();
	List<BasketVO> getUserBaskets(int userId);
	boolean registBasket(BasketVO basketVO);
	boolean updateBasket(BasketVO basketVO);
	boolean deleteBasket(BasketVO basketVO);
}
