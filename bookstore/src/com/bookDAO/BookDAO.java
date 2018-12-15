package com.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/book_score";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Ankit310!";
	private Connection jdbcConnection = null;

	public void connect() throws ClassNotFoundException {
		try {
			if (jdbcConnection == null || jdbcConnection.isClosed()) {
				// Open a connection
//				System.out.println("Connecting to database...");
//				return DriverManager.getConnection(dbURL, username, password);
				Class.forName("com.mysql.jdbc.Driver");
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
				System.out.println("connection closed");
				jdbcConnection.close();
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
	}
}
}