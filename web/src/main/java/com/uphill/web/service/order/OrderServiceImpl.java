package com.uphill.web.service.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.OrderInfoVO;
import com.uphill.web.dto.OrderItemVO;

public class OrderServiceImpl implements OrderService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

	@Override
	public int order(OrderInfoVO orderInfoVO) {
		int result = 0;
		Map<String, List<OrderItemVO>> orderItemMap = new HashMap<String, List<OrderItemVO>>();
		orderItemMap.put("list", orderInfoVO.getOrderItemList());
		Map<String, Integer> updatePointMap = new HashMap<String, Integer>();
		int usePoint = orderInfoVO.getOrderVO().getUsePoint();
		int point = orderInfoVO.getOrderVO().getPoint();
		int userIndex = orderInfoVO.getOrderVO().getUserIndex();
		updatePointMap.put("point", point - usePoint);
		updatePointMap.put("userIndex", userIndex);

		int insertOrderResult = orderMapper.insertOrder(orderInfoVO.getOrderVO());
		int insertOrderItemResult = orderMapper.insertOrderItem(orderItemMap);
		int updatePointResult = orderMapper.updatePoint(updatePointMap);
		
		if(insertOrderResult > 0 && insertOrderItemResult > 0 && updatePointResult > 0) {
			sqlSession.commit();
			result = insertOrderResult + insertOrderItemResult + updatePointResult;
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
}
