package com.mindtree.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.entities.Student;

public interface StudentService {

	abstract Student getStudentByName(String name) throws SQLException;

	abstract ArrayList<Student> getStudentsByCollege(String sname);

	abstract ArrayList<Student> sortByNames();

	abstract String addStudent(Student s1);
	
	
}
