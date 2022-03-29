package com.uphill.web.data.promotion.service;

import java.util.List;

import com.uphill.web.data.promotion.dto.PromotionVO;

public interface PromotionService {
	List<PromotionVO> getAllPromotions();
	PromotionVO getPromotion(int promotionId);
	boolean registPromotion(PromotionVO promotionVO);
	boolean updatePromotionVO(PromotionVO promotionVO);
	boolean deletePromotionVO(PromotionVO promotionVO);
}
