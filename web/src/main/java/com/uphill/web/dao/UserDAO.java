package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.user.UserVO;
import com.uphill.web.util.SHA256Encoder;

public class UserDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public UserVO selectUser(UserVO userVO) {
		UserVO newUserVO = null;
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select user_id, user_enter_id, user_name, gender, birth, mobile_carrier, phone_number, address, address_detail, email from user_table where user_enter_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserEnterId());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				newUserVO = new UserVO();
				newUserVO.setUserId(Integer.parseInt(resultSet.getString("user_id")));
				newUserVO.setUserEnterId(resultSet.getString("user_enter_id"));
				newUserVO.setUserName(resultSet.getString("user_name"));
				newUserVO.setGender(resultSet.getString("gender").charAt(0));
				newUserVO.setBirth(resultSet.getDate("birth"));
				newUserVO.setMobileCarrier(resultSet.getString("mobile_carrier"));
				newUserVO.setPhoneNumber(resultSet.getString("phone_number"));
				newUserVO.setAddress(resultSet.getString("address"));
				newUserVO.setAddressDetail(resultSet.getString("address_detail"));
				newUserVO.setEmail(resultSet.getString("email"));
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
		
		return userVO;
	}
	
	public UserVO loginUser(UserVO userVO) {
		UserVO newUserVO = null;

		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select user_id, user_enter_id, user_name, gender, birth, mobile_carrier, phone_number, address, address_detail, email from user_table where user_enter_id = ? and user_password = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserEnterId());
			preparedStatement.setString(2, SHA256Encoder.encode(userVO.getUserPassword(), userVO.getSalt()));
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				newUserVO = new UserVO();
				newUserVO.setUserId(Integer.parseInt(resultSet.getString("user_id")));
				newUserVO.setUserEnterId(resultSet.getString("user_enter_id"));
				newUserVO.setUserName(resultSet.getString("user_name"));
				newUserVO.setGender(resultSet.getString("gender").charAt(0));
				newUserVO.setBirth(resultSet.getDate("birth"));
				newUserVO.setMobileCarrier(resultSet.getString("mobile_carrier"));
				newUserVO.setPhoneNumber(resultSet.getString("phone_number"));
				newUserVO.setAddress(resultSet.getString("address"));
				newUserVO.setAddressDetail(resultSet.getString("address_detail"));
				newUserVO.setEmail(resultSet.getString("email"));
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
		
		return newUserVO;
	}
	
	public int insertUser(UserVO userVO) {
		int result = 0;
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "insert into user_table(user_enter_id, user_password, user_name, gender, mobile_carrier, phone_number, address, address_detail, email, personal_agree, unique_agree, mobile_agree, use_agree, salt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserEnterId());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setString(4, Character.toString(userVO.getGender()));
			preparedStatement.setString(5, userVO.getMobileCarrier());
			preparedStatement.setString(6, userVO.getPhoneNumber());
			preparedStatement.setString(7, userVO.getAddress());
			preparedStatement.setString(8, userVO.getAddressDetail());
			preparedStatement.setString(9, userVO.getEmail());
			preparedStatement.setBoolean(10, userVO.isPersonalAgree());
			preparedStatement.setBoolean(11, userVO.isUniqueAgree());
			preparedStatement.setBoolean(12, userVO.isMobileAgree());
			preparedStatement.setBoolean(13, userVO.isUseAgree());
			preparedStatement.setString(14, userVO.getSalt());
			
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
		
		return result;
	}
	
	public String selectUserSalt(UserVO userVO) {
		String salt = "";
		
		connection = DataBaseUtil.getConnection();

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