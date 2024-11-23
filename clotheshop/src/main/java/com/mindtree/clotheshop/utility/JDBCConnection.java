package com.mindtree.clotheshop.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.clotheshop.exception.ConnectionFailedException;

public class JDBCConnection {
	private static final String url = "jdbc:mysql://localhost:3306/clotheshop??autoReconnect=true&useSSL=false";
	private static final String user_name = "root";
	private static final String password = "rgukt123";

	public static Connection Connectivity() throws ConnectionFailedException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user_name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectionFailedException("Connection failed");
		}
		return con;

	}

}
