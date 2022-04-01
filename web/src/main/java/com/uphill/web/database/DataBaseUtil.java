package com.uphill.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public interface DataBaseUtil {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context)initialContext.lookup("java:comp/env");
			
			// name으로 커넥션 풀인 DataSource객체를 얻어와
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/MySQLDB");
			
			connection = dataSource.getConnection(); // Connection 객체를 얻어와
			
			connection.setAutoCommit(false); // Connection객체의 트랜잭션을 자동 커밋되지 않도록 하기 위해
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement statement) {
		try {
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection connection) {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
