package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.UserVO;
import com.uphill.web.util.SHA256Encoder;

public class UserDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public UserVO selectUser(UserVO userVO) {
		UserVO newUserVO = null;
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select user_index, user_id, user_name, gender, birth, mobile_carrier, phone_number, address, address_detail, email from user_table where user_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserId());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				newUserVO = new UserVO();
				newUserVO.setUserIndex(Integer.parseInt(resultSet.getString("user_index")));
				newUserVO.setUserId(resultSet.getString("user_id"));
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
			String sql = "select user_index, user_id, user_name, gender, birth, mobile_carrier, phone_number, address, address_detail, email from user_table where user_id = ? and user_password = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserId());
			preparedStatement.setString(2, SHA256Encoder.encode(userVO.getUserPassword(), userVO.getSalt()));
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				newUserVO = new UserVO();
				newUserVO.setUserIndex(Integer.parseInt(resultSet.getString("user_index")));
				newUserVO.setUserId(resultSet.getString("user_id"));
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
			String sql = "insert into user_table(user_id, user_password, user_name, gender, birth, mobile_carrier, phone_number, address, address_detail, address_extra, email, personal_agree, unique_agree, mobile_agree, use_agree, salt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			Date birth = null;
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = simpleDateFormat.format(userVO.getBirth());
				birth = Date.valueOf(formattedDate);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserId());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setString(4, Character.toString(userVO.getGender()));
			preparedStatement.setDate(5, birth);
			preparedStatement.setString(6, userVO.getMobileCarrier());
			preparedStatement.setString(7, userVO.getPhoneNumber());
			preparedStatement.setString(8, userVO.getAddress());
			preparedStatement.setString(9, userVO.getAddressDetail());
			preparedStatement.setString(10, userVO.getAddressExtra());
			preparedStatement.setString(11, userVO.getEmail());
			preparedStatement.setBoolean(12, userVO.isPersonalAgree());
			preparedStatement.setBoolean(13, userVO.isUniqueAgree());
			preparedStatement.setBoolean(14, userVO.isMobileAgree());
			preparedStatement.setBoolean(15, userVO.isUseAgree());
			preparedStatement.setString(16, userVO.getSalt());
			
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
	
	public String selectUserSalt(String userId) {
		String salt = "";
		
		connection = DataBaseUtil.getConnection();

		try {
			String sql = "select salt from user_table where user_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			
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
	
	public String selectUserId(UserVO userVO) {
		String userId = "";
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select user_id from user_table where user_name = ? and birth = ? and mobile_carrier = ? and phone_number = ? and email = ?";
			
			Date birth = null;
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = simpleDateFormat.format(userVO.getBirth());
				birth = Date.valueOf(formattedDate);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userVO.getUserName());
			preparedStatement.setDate(2, birth);
			preparedStatement.setString(3, userVO.getMobileCarrier());
			preparedStatement.setString(4, userVO.getPhoneNumber());
			preparedStatement.setString(5, userVO.getEmail());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userId = resultSet.getString("user_id");
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
		
		return userId;
	}
	
	public int updateUserPassword(UserVO userVO) {
		int result = 0;
		
		connection = DataBaseUtil.getConnection();

		try {
			String sql = "update user_table set user_password=? where user_id=? and user_name=? and birth=? and mobile_carrier=? and phone_number=? and email=?";
			
			Date birth = null;
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = simpleDateFormat.format(userVO.getBirth());
				birth = Date.valueOf(formattedDate);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, SHA256Encoder.encode(userVO.getUserPassword(), userVO.getSalt()));
			preparedStatement.setString(2, userVO.getUserId());
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setDate(4, birth);
			preparedStatement.setString(5, userVO.getMobileCarrier());
			preparedStatement.setString(6, userVO.getPhoneNumber());
			preparedStatement.setString(7, userVO.getEmail());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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
			}
		}
		
		return result;
	}

	public boolean selectUserId(String userId) {
		boolean result = false;
		
		connection = DataBaseUtil.getConnection();

		try {
			String sql = "select user_id from user_table where user_id = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = true;
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
		
		return result;
	}

	public boolean selectUserEmail(String email) {
boolean result = false;
		
		connection = DataBaseUtil.getConnection();

		try {
			String sql = "select user_id from user_table where email = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				result = true;
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
		
		return result;
	}
}
