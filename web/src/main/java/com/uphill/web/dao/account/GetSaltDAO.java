package com.uphill.web.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.user.UserVO;

public class GetSaltDAO {
	
	public String selectUserSalt(UserVO userVO) {
		String salt = "";
		
		Connection connection = DataBaseUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		if(connection == null) {
			return null;
		}
		
		try {
			String sql = "select salt from user_table where user_enter_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserEnterId());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				salt = resultSet.getString("salt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return salt;
	}
	
}
