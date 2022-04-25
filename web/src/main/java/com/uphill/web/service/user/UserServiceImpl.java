package com.uphill.web.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.OrderItemInfoVO;
import com.uphill.web.dto.OrderListVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserVO;
import com.uphill.web.service.order.OrderMapper;

public class UserServiceImpl implements UserService {
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
		
		sqlSession.close();
		
		return orderListVO;
	}

	@Override
	public int updateUser(UserVO userVO) {
		int result = orderMapper.updateUser(userVO);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public int leaveUser(int userIndex) {
		int result = orderMapper.deleteUser(userIndex);
		
		sqlSession.close();
		
		return result;
	}
	
	
}
