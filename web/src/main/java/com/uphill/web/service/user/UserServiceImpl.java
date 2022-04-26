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
		OrderListVO orderListVO = null;
		List<OrderVO> orderList = orderMapper.selectOrderList(userIndex);
		if(orderList.size() != 0) {			
			List<Integer> orderIndexList = new ArrayList<Integer>();
			for(OrderVO orderVo : orderList) {
				orderIndexList.add(orderVo.getOrderIndex());
			}
			List<OrderItemInfoVO> orderItemList = orderMapper.selectOrderItemList(orderIndexList);
			
			orderListVO = new OrderListVO(orderList, orderItemList);	
		}
		
		sqlSession.close();
		
		return orderListVO;
	}

	@Override
	public UserVO updateUser(UserVO userVO) {
		int result = orderMapper.updateUser(userVO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		UserVO newUserVO = orderMapper.selectUser(userVO.getUserIndex());
		
		sqlSession.close();
		
		return newUserVO;
	}

	@Override
	public int leaveUser(int userIndex) {
		int result = orderMapper.deleteUser(userIndex);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	
}
