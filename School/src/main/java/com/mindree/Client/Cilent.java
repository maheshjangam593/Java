package com.mindree.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.Service.StudentService;
import com.mindtree.Serviceimpl.StudentServiceImpl;
import com.mindtree.entities.Student;

public class Cilent {
	static Scanner sc = new Scanner(System.in);

	static StudentService obj = new StudentServiceImpl();
	static ArrayList<Student> college = new ArrayList<>();
	static ArrayList<Student> names = new ArrayList<>();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int op = 0;

		do {
			System.out.println(
					"1.add Student Detalis \n2.get Student details By name\n3. getStudents by college\4. SortBy Names of Students\5.exit");
			;
			op = sc.nextInt();
			switch (op) {
			case 1:
				Student s1 = addStudentDetails();
				System.out.println(obj.addStudent(s1));
				break;
			case 2:
				
				System.out.println("enter name");
				sc.nextLine();
				String name = sc.nextLine();
				s1 = obj.getStudentByName(name);
				display(s1);
				break;
			case 3:
				System.out.println("enter School name");
				String sname = sc.nextLine();
				college = obj.getStudentsByCollege(sname);
				displayCollege(college);
				break;
			case 4:
				names = obj.sortByNames();
				displayStudent(names);
				break;

			case 5:
				break;
			default:
				System.out.println("Invalid Option");
				break;

			}
		} while (op != 5);

	}

	private static void displayStudent(ArrayList<Student> names2) {
		// TODO Auto-generated method stub

	}

	private static void displayCollege(ArrayList<Student> college2) {
		// TODO Auto-generated method stub

	}

	private static void display(Student s1) {
		// TODO Auto-generated method stub
		System.out.println(s1);

	}

	private static Student addStudentDetails() {
		// TODO Auto-generated method stub
		System.out.println("enter student id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("enter Student name");
		String name = sc.nextLine();
		System.out.println("enter Standard");
		String standard = sc.next();
		sc.nextLine();
		System.out.println("Schoolename");
		String sname = sc.nextLine();
		System.out.println("enter Address");
		String add = sc.nextLine();
		Student s1 = new Student(id, name, standard, sname, add);
		return s1;
	}

}
