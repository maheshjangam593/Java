package com.mindtree.Utility;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mindtree.Exception.ConnectionException;
import com.mysql.jdbc.Connection;

public class Validatons {
	static Scanner sc = new Scanner(System.in);

	private static final String url = "jdbc:mysql://localhost:3306/MobileData??autoReconnect=true&useSSL=false";
	private static final String user_Name = "root";
	private static final String password = "rgukt123";

	public static Connection Connectivity() throws ConnectionException {
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(url, user_Name, password);
			System.out.println("database it connected");
		}
		catch (SQLException e) {
			throw new ConnectionException(e);
		}
		return con;
	}
	public int validateInt() {
		// TODO Auto-generated method stub
		int op = sc.nextInt();
		sc.nextLine();
		return op;
	}

//validate string
	public static String validateString() {
		String s = sc.nextLine();
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				// int ch = (int) (s.charAt(i));
				char ch = s.charAt(i);
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 || ch == 32) {
					count++;
				}
			}
			if (count != s.length() || s.length() < 3) {
				System.out.println("invalid input:once again enter");
				s = sc.next();
			} else {
				isValid = false;
			}

		}
		return s;
	}
}
