package com.uphill.web.service.home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.HomeVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.MainBannerVO;
import com.uphill.web.dto.ReviewVO;

public class HomeServiceImpl implements HomeService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
	
	@Override
	public HomeVO getMainPage() {
		List<MainBannerVO> mainBannerList = homeMapper.selectMainBannerList();
		List<ItemVO> bestSellerList = homeMapper.selectBestSellerList(4);
		List<ItemVO> bestItemList = homeMapper.selectBestItemList(6);
		List<ReviewVO> recentReviewList = homeMapper.selectRecentReviewList(8);
		
		HomeVO homeVO = new HomeVO(mainBannerList, bestSellerList, bestItemList, recentReviewList);

		sqlSession.close();
		
		return homeVO;
	}	
}
