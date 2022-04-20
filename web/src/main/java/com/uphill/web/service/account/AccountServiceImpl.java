package com.uphill.web.service.account;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.UserVO;

public class AccountServiceImpl implements AccountService {
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private AccountMapper userMapper = sqlSession.getMapper(AccountMapper.class);
	
	@Override
	public UserVO login(UserVO userVO) {
		UserVO loginUserVO = userMapper.selectLoginUser(userVO);		
		
		sqlSession.close();
		
		return loginUserVO;
	}
	
	@Override
	public String findUserId(UserVO userVO) {	
		String userId = userMapper.selectUserId(userVO);		
		
		sqlSession.close();

		return userId;
	}
	
	@Override
	public int join(UserVO userVO) {				
		int result = userMapper.insertUser(userVO);
		
		if(result > 0) {
			sqlSession.commit();			
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int updatePassword(UserVO userVO) {		
		int result =  userMapper.updateUserPassword(userVO);
		
		if(result > 0) {
			sqlSession.commit();			
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		
		return result;
	}
	
	@Override
	public boolean checkDuplicateId(String userId) {
		boolean result = userMapper.selectDuplicateUserId(userId);

		sqlSession.close();
		
		return result;
	}
	
	@Override
	public boolean checkDuplicateEmail(String email) {		
		boolean result = userMapper.selectDuplicateEmail(email);
		
		sqlSession.close();
		
		return result;
	}
}
