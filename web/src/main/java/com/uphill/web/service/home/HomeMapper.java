package com.uphill.web.service.home;

import java.util.List;

import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.MainBannerVO;
import com.uphill.web.dto.ReviewVO;

public interface HomeMapper {
	List<MainBannerVO> selectMainBannerList();
	List<ItemVO> selectBestSellerList(int count);
	List<ItemVO> selectBestItemList(int count);
	List<ReviewVO> selectRecentReviewList(int count);
}
