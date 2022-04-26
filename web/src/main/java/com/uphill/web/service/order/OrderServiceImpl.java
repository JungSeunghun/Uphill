package com.uphill.web.service.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserVO;

public class OrderServiceImpl implements OrderService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

	@Override
	public UserVO order(OrderVO orderVO, OrderItemVO orderItemVO, int purchase) {
		Map<String, Integer> updateUsereMap = new HashMap<String, Integer>();
		int usePoint = orderVO.getUsePoint();
		int point = orderVO.getPoint();
		int totalPrice = orderVO.getTotalPrice();
		int userIndex = orderVO.getUserIndex();
		updateUsereMap.put("point", point - usePoint);
		updateUsereMap.put("purchase", purchase + totalPrice);
		updateUsereMap.put("userIndex", userIndex);

		int seletOrderIndex = orderMapper.selectOrderIndex();
		orderVO.setOrderIndex(seletOrderIndex);
		orderItemVO.setOrderIndex(seletOrderIndex);
		
		int insertOrderResult = orderMapper.insertOrder(orderVO);
		int insertOrderItemResult = orderMapper.insertOrderItem(orderItemVO);
		int updateUserResult = orderMapper.updateUser(updateUsereMap);
		
		if(insertOrderResult > 0 && insertOrderItemResult > 0 && updateUserResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		UserVO userVO = orderMapper.selectUser(userIndex);
		
		sqlSession.close();
		
		return userVO;
	}
	
	@Override
	public UserVO orderBasket(OrderVO orderVO, List<OrderItemVO> orderItemList, int purchase) {
		Map<String, List<OrderItemVO>> orderItemMap = new HashMap<String, List<OrderItemVO>>();
		Map<String, Integer> updateUsereMap = new HashMap<String, Integer>();
		int usePoint = orderVO.getUsePoint();
		int point = orderVO.getPoint();
		int totalPrice = orderVO.getTotalPrice();
		int userIndex = orderVO.getUserIndex();
		updateUsereMap.put("point", point - usePoint);
		updateUsereMap.put("purchase", purchase + totalPrice);
		updateUsereMap.put("userIndex", userIndex);

		int seletOrderIndex = orderMapper.selectOrderIndex();
		orderVO.setOrderIndex(seletOrderIndex);
		for(OrderItemVO orderItemVO : orderItemList) {
			orderItemVO.setOrderIndex(seletOrderIndex);
		}
		orderItemMap.put("list", orderItemList);
		
		int insertOrderResult = orderMapper.insertOrder(orderVO);
		int insertOrderItemResult = orderMapper.insertOrderItemList(orderItemMap);
		int updateUserResult = orderMapper.updateUser(updateUsereMap);
		int deleteBasketResult = orderMapper.deleteBasket(userIndex);
		
		if(insertOrderResult > 0 && insertOrderItemResult > 0 && updateUserResult > 0 && deleteBasketResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		UserVO userVO = orderMapper.selectUser(userIndex);

		sqlSession.close();
		
		return userVO;
	}
	
}
