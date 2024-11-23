package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Validations {
	private static final String url = "jdbc:mysql://localhost:3306/StudentData??autoReconnect=true&useSSL=false";
	private static final String user_name = "root";
	private static final String password = "rgukt123";

	public static Connection Connectivity() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection(url, user_name, password);
		return con;

	}

	public static void closeConnetion(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		con.close();
	}
}
