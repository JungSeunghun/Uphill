package com.uphill.web.service.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.OrderItemVO;
import com.uphill.web.dto.OrderListVO;
import com.uphill.web.dto.OrderVO;

public class UserServiceImpl implements UserService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private UserMapper orderMapper = sqlSession.getMapper(UserMapper.class);
	
	@Override
	public OrderListVO getOrderList(int userIndex) {
		List<OrderVO> orderList = orderMapper.selectOrderList(userIndex);
		List<OrderItemVO> orderItemList = orderMapper.selectOrderItemList(userIndex);
		
		OrderListVO orderListVO = new OrderListVO(orderList, orderItemList);	
		
		return orderListVO;
	}

}
