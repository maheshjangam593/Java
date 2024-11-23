package com.mindtree.Album.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.Album.exceptions.ConnectionFailedException;

public class JDBCConnection {
	private static final String url = "jdbc:mysql://localhost:3306/album??autoReconnect=true&useSSL=false";
	private static final String user_name = "root";
	private static final String password = "rgukt123";
	public static Connection Connectivity() throws ConnectionFailedException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user_name, password);
		} catch (SQLException e) {
			throw new ConnectionFailedException("Connection Failed");
		}
		return con;
	}
	public static void closeResource(Connection con) throws ConnectionFailedException {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectionFailedException("Connection failed");
		}
	}
	public static void closeResource(PreparedStatement st) throws ConnectionFailedException {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectionFailedException("Connection failed");
		}
	}

	public static void closeResource(ResultSet rs) throws ConnectionFailedException { // TODO Auto-generated method stub
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ConnectionFailedException("Connection failed");

		}

	}

}
