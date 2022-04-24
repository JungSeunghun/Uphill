package com.uphill.web.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.OrderItemInfoVO;
import com.uphill.web.dto.OrderListVO;
import com.uphill.web.dto.OrderVO;

public class UserServiceImpl implements UserService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private UserMapper orderMapper = sqlSession.getMapper(UserMapper.class);
	
	@Override
	public OrderListVO getOrderList(int userIndex) {
		List<OrderVO> orderList = orderMapper.selectOrderList(userIndex);
		List<Integer> orderIndexList = new ArrayList<Integer>();
		for(OrderVO orderVo : orderList) {
			orderIndexList.add(orderVo.getOrderIndex());
		}
		List<OrderItemInfoVO> orderItemList = orderMapper.selectOrderItemList(orderIndexList);
		
		OrderListVO orderListVO = new OrderListVO(orderList, orderItemList);	
		
		return orderListVO;
	}

}
