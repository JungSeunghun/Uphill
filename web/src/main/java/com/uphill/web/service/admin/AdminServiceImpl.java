package com.uphill.web.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.ItemInfoVO;
import com.uphill.web.dto.ItemListInfoVO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemVO;
import com.uphill.web.dto.OrderInfoVO;
import com.uphill.web.dto.OrderItemInfoVO;
import com.uphill.web.dto.OrderListInfoVO;
import com.uphill.web.dto.OrderVO;
import com.uphill.web.dto.UserListInfoVO;
import com.uphill.web.dto.UserVO;

public class AdminServiceImpl implements AdminService {
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
	
	@Override
	public UserListInfoVO getUserListInfo(int page, int count) {		
		int startNum = (page-1) * count;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("count", count);
		
		List<UserVO> userList = adminMapper.selectUserList(map);
		int totalCount = adminMapper.selectUserCount();
		
		UserListInfoVO userListInfoVO = new UserListInfoVO(userList, totalCount);
		
		sqlSession.close();
		
		return userListInfoVO;
	}

	@Override
	public UserVO getUserInfo(int userIndex) {
		UserVO userInfo = adminMapper.selectUser(userIndex);		
		
		sqlSession.close();
		
		return userInfo;
	}

	@Override
	public int deleteUser(int userIndex) {
		int result = adminMapper.deleteUser(userIndex);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public OrderListInfoVO getOrderListInfo(int orderPage, int count) {
		int startNum = (orderPage-1) * count;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("count", count);
		
		List<OrderVO> orderList = adminMapper.selectOrderList(map);
		int totalCount = adminMapper.selectOrderCount();
		
		OrderListInfoVO orderListInfoVO = new OrderListInfoVO(orderList, totalCount);
		
		sqlSession.close();
		
		return orderListInfoVO;
	}

	@Override
	public OrderInfoVO getOrderInfo(int orderIndex) {
		OrderVO orderVO = adminMapper.selectOrder(orderIndex);
		List<OrderItemInfoVO> orderItemInfoList = adminMapper.selectOrderItemInfoList(orderIndex);
				
		OrderInfoVO orderInfoVO = new OrderInfoVO(orderVO, orderItemInfoList);
		
		sqlSession.close();
		
		return orderInfoVO;
	}

	@Override
	public int updateOrder(int orderState, int orderIndex) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("orderState", orderState);
		map.put("orderIndex", orderIndex);
		
		int result = adminMapper.updateOrder(map);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public ItemListInfoVO getItemListInfo(int itemPage, int count) {
		int startNum = (itemPage-1) * count;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("count", count);
		
		List<ItemVO> itemList = adminMapper.selectItemList(map);
		int totalCount = adminMapper.selectItemCount();
		
		ItemListInfoVO itemListInfoVO = new ItemListInfoVO(itemList, totalCount);
		
		sqlSession.close();
		
		return itemListInfoVO;
	}

	@Override
	public ItemInfoVO getItemInfo(int itemIndex) {
		ItemVO itemVO = adminMapper.selectItem(itemIndex);
		List<ItemOptionVO> itemOptionList = adminMapper.selectItemOptionList(itemIndex);
		
		ItemInfoVO itemInfoVO = new ItemInfoVO(itemVO, itemOptionList);
		
		sqlSession.close();
		
		return itemInfoVO;
	}
	
}
