package com.mindtree.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.Dao.StdentDao;
import com.mindtree.entities.Student;
import com.mindtree.utilities.Validations;

public class StudentDaoImpl implements StdentDao {

	@Override
	public String insertStudent(Student s1) throws SQLException {
		// TODO Auto-generated method stub
		String message = "";
		PreparedStatement st = null;
		int count = 0;
		Connection con = null;
		try {
			con = Validations.Connectivity();
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "insert into student values(?,?,?,?,?);";
		st = con.prepareStatement(query);
		st.setInt(1, s1.getId());
		st.setString(2, s1.getName());
		st.setString(3, s1.getStandard());
		st.setString(4, s1.getsName());
		st.setString(5, s1.getAddress());
		st.executeUpdate();
	
			message = "Inserted Succefully";
			st.close();
		
		Validations.closeConnetion(con);

		return message;
	}

	@Override
	public Student getStudentName(String name) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement st = null;
		int count = 0;
		Connection con = null;
		Student s2 = null;
		ResultSet rs = null;
		try {
			con = Validations.Connectivity();
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query1 = "select * from student where name='" + name + "';";
		st = con.prepareStatement(query1);
		rs = st.executeQuery();
		while (rs.next()) {
			s2 = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		return s2;
	}

}
