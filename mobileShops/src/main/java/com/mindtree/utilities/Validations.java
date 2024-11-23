package com.mindtree.utilities;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;

public class Validations {
	static Scanner sc = new Scanner(System.in);
	private static final String url = "jdbc:mysql://localhost:3306/ShopDatabase??autoReconnect=true&useSSL=false";
	private static final String user_Name = "root";
	private static final String password = "rgukt123";

	public static Connection Connectivity() throws SQLException {
		Connection con = null;
		con = (Connection) DriverManager.getConnection(url, user_Name, password);
		System.out.println("database it connected");

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

	// validate double
	public static float validateFloat() {
		float wt = sc.nextFloat();
		boolean isValid = true;
		while (isValid) {
			if (wt <= 0) {
				System.out.println("invalid input:\nit should not be negative number:once again enter:");
				wt = sc.nextFloat();
			} else {
				isValid = false;
			}
		}
		return wt;
	}

	public static void closeResourse(Connection con) {
		// TODO Auto-generated method stub
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

	}

	

}
