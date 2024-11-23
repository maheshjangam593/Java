package com.mindtree.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.mindtree.ServiceImpl.AdminOperations;
import com.mindtree.ServiceImpl.CustomerOperation;
import com.mindtree.entities.Admin;
import com.mindtree.entities.Customer;
import com.mindtree.entities.Food;

public class ClientDemo {
	static Scanner sc = new Scanner(System.in);
	static Admin obj = new Admin();
	static Customer cus = new Customer();
	static HashMap<String, ArrayList> hm = new HashMap<>();
	static CustomerOperation co = new CustomerOperation();
	static AdminOperations ao = new AdminOperations();
	static 	ArrayList<Food> fd=new ArrayList<>();
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Admin ad = new Admin();
		Customer cm = new Customer();
		createFood();
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			adminPanel();
			break;
		case 2:
			CustomerPanel();
			break;
		default:
			System.out.println("enter valid option");
			break;
		}
	}

	public static HashMap<String, ArrayList> getHashMap() {
		return hm;

	}

	private static void createFood() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println("food name");
			String name = sc.next();
			fd.add(new Food(name, 3));
			hm.put(name, fd);
		}
	}

	private static void CustomerPanel() {
		// TODO Auto-generated method stub

		ArrayList<Customer> ad = createCustomer();
		System.out.println("enter admin id");
		int id = sc.nextInt();
		boolean login = false;
		for (Customer a : ad) {
			if (a.getcId() == id) {
				login = true;
			}
		}
		if (login) {
			System.out.println("enter option");
			int choice = sc.nextInt();
			do {
				switch (choice) {
				case 1:
					co.getFood();
					break;
				case 2:
					co.logOut();

					break;
				case 3:

					break;

				}
			} while (choice == 3);
		}

		else {
			System.out.println("cutomer not found");
		}
	}

	private static ArrayList<Customer> createCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Customer> ad = new ArrayList<>();
		System.out.println("enter customerName name");
		cus.setName(sc.next());
		System.out.println("enter customer email");
		cus.setEmail(sc.next());
		System.out.println("password");
		cus.setPassword(sc.next());
		ad.add(cus);
		return ad;

	}

	private static void adminPanel() throws SQLException {

		// TODO Auto-generated method stub
		Admin ad = createNewAdmin();
		ao.insertAdmin(ad);
boolean login=false;
		System.out.println("enter admin id");
		int id = sc.nextInt();
		if(ao.isExist(id)) {
			login =true;
		
		if (login) {
			int choice = 0;

			do {
				System.out.println("1.");
				System.out.println("Choose option");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					ao.counterAvailable();
					break;
				case 2:
					ao.totalFood();
					break;
				case 3:
					ao.ListOfCustomer();
					break;
				case 4:
					ao.NoOfCounterCreated();
					break;
				case 5:
					ao.removeFooditem();
					break;
				case 6:
					ao.ParticularCustomer();
					break;
				case 7:
					adminPanel();
					break;

				case 8:
					ao.logout();
					break;
				case 9:

					break;

				}
			} while (choice == 9);
		} else {
			System.out.println("admin not found");
		}}
	}

	private static Admin createNewAdmin() {
		// TODO Auto-generated method stub
		Admin ad = new Admin();
		System.out.println("enter admin name");
		ad.setAdminName(sc.next());
		System.out.println("enter admin id");
		ad.setAdminId(sc.nextInt());
		System.out.println("password");
		ad.setPassword(sc.next());

		return ad;
	}

}
