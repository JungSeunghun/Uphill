package com.uphill.web.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.uphill.web.dto.UserVO;

public class UserDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/uphill/web/database/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UserVO selectUser(int userIndex) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserVO userVO = sqlSession.selectOne("selectUser", userIndex);
		
		sqlSession.close();
		
		return userVO;		
	}

	public UserVO loginUser(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserVO loginUserVO = sqlSession.selectOne("loginUser", userVO);
		
		sqlSession.close();
		
		return loginUserVO;		
	}
	
	public int insertUser(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = sqlSession.insert("insertUser", userVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;	
	}
	
	public String selectUserSalt(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String salt = sqlSession.selectOne("selectUserSalt", userId);
		
		sqlSession.close();
		
		return salt;	
	}
	
	public String selectUserId(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String userId = sqlSession.selectOne("selectUserId", userVO);
		
		sqlSession.close();
		
		return userId;
	}
	
	public int updateUserPassword(UserVO userVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		int result = sqlSession.update("updateUserPassword", userVO);
		
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	public boolean selectDuplicateUserId(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String userDuplicateId = sqlSession.selectOne("selectDuplicateUserId", userId);
		
		sqlSession.close();
		
		if(userDuplicateId != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean selectDuplicateEmail(String email) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String duplicateEmail = sqlSession.selectOne("selectDuplicateEmail", email);
		
		sqlSession.close();
		
		if(duplicateEmail != null) {
			return true;
		} else {
			return false;
		}
	}

}
