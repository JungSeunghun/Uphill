package com.uphill.web.data.mainbanner.service;

import java.util.List;

import com.uphill.web.data.mainbanner.dto.MainBannerVO;

public interface MainBannerService {
	List<MainBannerVO> getMainBannerList();
	MainBannerVO getMainBanner(int mainBannerId);
	boolean registMainBanner(MainBannerVO mainBannerVO);
	boolean updateMainBanner(MainBannerVO mainBannerVO);
	boolean deleteMainBanner(MainBannerVO mainBannerVO);
}
