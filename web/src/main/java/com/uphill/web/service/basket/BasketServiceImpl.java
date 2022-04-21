package com.uphill.web.service.basket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.BasketVO;

public class BasketServiceImpl implements BasketService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private BasketMapper basketMapper = sqlSession.getMapper(BasketMapper.class);
	
	@Override
	public int insertBasket(BasketVO basketVO) {
		int result = basketMapper.insertBasket(basketVO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public List<BasketItemVO> getBasketItemList(int userIndex) {
		List<BasketItemVO> basketItemList = basketMapper.selectBasketItemList(userIndex);
		
		sqlSession.close();
		
		return basketItemList;
	}
	
	@Override
	public int updateBasket(int userIndex, int basketIndex, int optionQty) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userIndex", userIndex);
		map.put("basketIndex", basketIndex);
		map.put("optionQty", optionQty);
		
		int result = basketMapper.updateBasket(map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int cancelBasket(int userIndex, int basketIndex) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userIndex", userIndex);
		map.put("basketIndex", basketIndex);
		
		int result = basketMapper.deleteBasket(map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int cancelBasketList(int userIndex) {
		int result = basketMapper.deleteBasketList(userIndex);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
}
