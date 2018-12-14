package com.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/book_store";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Ankit310!";
	private Connection jdbcConnection;

	public void connect() {
		try {
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				System.out.println("MySQL Connection Established");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() throws SQLException {
		try {
			if (jdbcConnection != null && !jdbcConnection.isClosed()) {
				jdbcConnection.close();
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
	}
}
}