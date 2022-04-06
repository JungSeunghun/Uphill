package com.uphill.web.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.util.SHA256Encoder;

public class JoinDAO {
	
	public boolean insertUser(UserVO userVO) {
		int result = 0;
		
		Connection connection = DataBaseUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		if(connection == null) {
			return false;
		}
		
		try {
			String sql = "insert into user_table(user_enter_id, user_password, user_name, gender, mobile_carrier, phone_number, address, address_detail, email, salt) values(?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserEnterId());
			preparedStatement.setString(2, SHA256Encoder.encode(userVO.getUserPassword(), userVO.getSalt()));
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setString(4, Character.toString(userVO.getGender()));
			preparedStatement.setString(5, userVO.getMobileCarrier());
			preparedStatement.setString(6, userVO.getPhoneNumber());
			preparedStatement.setString(7, userVO.getAddress());
			preparedStatement.setString(8, userVO.getAddressDetail());
			preparedStatement.setString(9, userVO.getEmail());
			preparedStatement.setString(10, userVO.getSalt());
			
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
				result = 0;
			}
		}
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}
