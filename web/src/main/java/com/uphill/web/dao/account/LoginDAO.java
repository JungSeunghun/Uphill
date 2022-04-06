package com.uphill.web.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.user.UserVO;

public class LoginDAO {
	public boolean selectUser(UserVO userVO) {
		Connection connection = DataBaseUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		if(connection == null) {
			return false;
		}
		
		try {
			String sql = "select user_id from user_table where user_enter_id = ? and user_password = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserEnterId());
			preparedStatement.setString(2, userVO.getUserPassword());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return true;
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
		
		return false;
	}
}
