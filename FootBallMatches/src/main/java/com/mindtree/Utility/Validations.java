package com.mindtree.Utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mindtree.Exceptions.InputMissMatchException;

public class Validations {
	static Scanner sc = new Scanner(System.in);
	private static final String url = "jdbc:mysql://localhost:3306/football??autoReconnect=true&useSSL=false";
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
