package com.uphill.web.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DataBaseUtil {
	Connection getConnection();
	void close(Connection connection);
	void close(Statement statement);
	void close(PreparedStatement preparedStatement);
	void close(ResultSet resultSet);
	void commit(Connection connection);	
	void rollback(Connection connection);	
}
