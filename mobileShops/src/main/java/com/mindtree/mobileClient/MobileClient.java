package com.mindtree.mobileClient;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobileShops.Mobile;
import com.mindtree.ServiceImpl.MobileServiceImpl;
import com.mindtree.services.MobileServices;
import com.mindtree.utilities.Validations;

public class MobileClient {
	static Validations iv = new Validations();
	static ArrayList<Mobile> shop = new ArrayList<Mobile>();
	static MobileServices ob = new MobileServiceImpl();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int op = 0;
		do {
			System.out.println(
					"1.enter details\n2.Show  details seprated by comma (,)\n3.show mobiles start with a character and rating lesser than some value\n4.sort  mobiles as per price\n5.exit");
			op = iv.validateInt();
			switch (op) {
			case 1:
				shop = ob.enterDeatils(shop);
				break;
			case 2:
				displaySeparetedByComma(shop);
				break;
			case 3:
				shop = ob.startWithCharAndRating(shop);
				display(shop);
				break;
			case 4:
				shop = ob.sortMobilesByPrice(shop);
				display(shop);
			case 5:
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}

		} while (op != 5);

	}

	private static void displaySeparetedByComma(ArrayList<Mobile> shop2) {
		// TODO Auto-generated method stub
		
		for(Mobile m:shop2) {
			System.out.print(m+",");
		}
	}

	private static void display(ArrayList<Mobile> shop2) {
		// TODO Auto-generated method stub
		for (Mobile m : shop2) {
			System.out.println(m);
		}

	}

}
