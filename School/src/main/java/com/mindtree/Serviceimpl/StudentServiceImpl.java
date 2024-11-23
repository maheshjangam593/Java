package com.mindtree.Serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.Dao.StdentDao;
import com.mindtree.DaoImpl.StudentDaoImpl;
import com.mindtree.Service.StudentService;
import com.mindtree.entities.Student;

public class StudentServiceImpl implements StudentService {

	StdentDao dao=new StudentDaoImpl();
	@Override
	public Student getStudentByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return this.dao.getStudentName(name);
	}

	@Override
	public ArrayList<Student> getStudentsByCollege(String sname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> sortByNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addStudent(Student s1) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			message = this.dao.insertStudent(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
		
}

	
	
	


