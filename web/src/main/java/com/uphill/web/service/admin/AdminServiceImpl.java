package com.uphill.web.service.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.UserVO;

public class AdminServiceImpl implements AdminService {
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
	
	@Override
	public List<UserVO> getUserList() {
		List<UserVO> userList = adminMapper.selectUserList();
		
		sqlSession.close();
		
		return userList;
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
	
}
