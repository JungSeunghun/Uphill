package com.uphill.web.data.mainBanner.service;

import java.util.List;

import com.uphill.web.data.mainBanner.dto.MainBannerVO;

public interface MainBannerService {
	List<MainBannerVO> getAllMainBanners();
	MainBannerVO getMainBanner(int mainBannerId);
	boolean registMainBanner(MainBannerVO mainBannerVO);
	boolean updateMainBanner(MainBannerVO mainBannerVO);
	boolean deleteMainBanner(MainBannerVO mainBannerVO);
}
