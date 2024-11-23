package com.mindtree.ServiceImpl;

import com.mindtree.services.MobileServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.mindtree.Dao.MobileSql;
import com.mindtree.mobileShops.Mobile;
import com.mindtree.services.MobileServices;
import com.mindtree.utilities.Validations;
import coom.mindtree.DaoImpl.MobileSqlImpl;
public class MobileServiceImpl implements MobileServices {

	MobileSqlImpl mobileSql = new MobileSqlImpl();
	static Scanner sc = new Scanner(System.in);
	Validations iv = new Validations();

	public ArrayList<Mobile> enterDeatils(ArrayList<Mobile> shop) {
		// TODO Auto-generated method stub
		System.out.println("enter id");
		int id = iv.validateInt();
		System.out.println("enter mobile name");
		String name = iv.validateString();
		System.out.println("enter rating");
		float rating = iv.validateFloat();
		System.out.println("enter price");
		float price = iv.validateFloat();
		try {
			shop.add(mobileSql.insertIntoTable(new Mobile(id, name, rating, price)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shop;
	}

	public ArrayList<Mobile> startWithCharAndRating(ArrayList<Mobile> shop) throws SQLException {
		System.out.println("enter initial char");
		char ch = sc.next().charAt(0);
		System.out.println("enter rating ");
		float rating = sc.nextFloat();
		shop = mobileSql.getDetailsStartWithCharAndRating(shop, ch, rating);

		return shop;
		// TODO Auto-generated method stub

	}

	public ArrayList<Mobile> sortMobilesByPrice(ArrayList<Mobile> shop) {
		try {
			return shop = mobileSql.sortByPrice(shop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shop;

	}
}
