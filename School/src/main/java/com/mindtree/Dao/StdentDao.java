package com.mindtree.Dao;

import java.sql.SQLException;

import com.mindtree.entities.Student;

public interface StdentDao {

	String insertStudent(Student s1) throws SQLException;

	Student getStudentName(String name) throws SQLException;

}
