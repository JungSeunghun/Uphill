/*
 * DB 관련 공통 기능 클래스
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 모든 메서드 static
public class JdbcUtil {
	// ★★먼저, context.xml에서 "오라클로 설정"
	// 커넥션 풀에서 Connection객체를 얻어와 반환하는 메서드
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context)initialContext.lookup("java:comp/env");
			
			// name으로 커넥션 풀인 DataSource객체를 얻어와
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/dogTest");
			
			connection = dataSource.getConnection(); // Connection 객체를 얻어와
			
			connection.setAutoCommit(false); // Connection객체의 트랜잭션을 자동 커밋되지 않도록 하기 위해
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/*connection객체를 닫아주는 메서드*/
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*statement객체를 닫아주는 메서드*/
	public static void close(Statement statement) {
		try {
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*preparedStatement객체를 닫아주는 메서드*/
	public static void close(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*resultSet객체를 닫아주는 메서드*/
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***********************************************************/
	
	/**
	 * 트랜잭션 중에 실행된 작업들을 '완료'시키는 메서드
	 * insert, update, delete 성공하면 commit실행
	 */
	public static void commit(Connection connection) {
		try {
			connection.commit();
			System.out.println("commit success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 트랜잭션 중에 실행된 작업들을 '취소'시키는 메서드
	 * insert, update, delete 실패하면 rollback실행
	 */
	public static void rollback(Connection connection) {
		try {
			connection.rollback();
			System.out.println("rollback success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}




