package com.mindtree.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.Exception.ClientException;
import com.mindtree.Exception.ServiceImplException;
import com.mindtree.ServiceImpl.MobileInterface;
import com.mindtree.ServiceImpl.MobileServiceImpl;
import com.mindtree.mobileShop.entity.Company;
import com.mindtree.mobileShop.entity.Mobile;

public class ClientDemo {
	static Scanner sc = new Scanner(System.in);
	static MobileInterface mb = (MobileInterface) new MobileServiceImpl();

	public static void main(String[] args) throws SQLException, ClientException {
		// TODO Auto-generated method stub
		ArrayList<Company> cm = new ArrayList<Company>();
		ArrayList<Mobile> mbb = new ArrayList<>();
		Company ic = new Company();
		int op = 0;
		do {
			System.out.println(
					"1.add Company details \n2.add mobile deatails\n3.show mobiles as per companyNmae\n4.sort  mobiles as per price and rating \n5.sort Mobiles as per company Nmae\n6.show expensive mobile of each company\n7.exit");
			op = sc.nextInt();
			switch (op) {
			case 1:
				ic = addCompanyDeatils();
				cm = mb.addCompanyDeatils(ic);
				break;
			case 2:
				cm = mb.getCompanyDetails();
				displayMobile(cm);
				Mobile im = addMobileDetails(ic);
				try {
					mb.addMobileDetails(im);
				} catch (ServiceImplException e) {
					System.out.println(e.getMessage());
				}
				cm = null;
				break;
			case 3:
				System.out.println("enter compny name");
				String name = sc.next();
				mbb = mb.showMobilesAsperComapnyName(name);
				display(mbb);
				break;
			case 4:
				mbb = mb.sortMobilesByPriceandRating();

				display(mbb);
				mbb = null;
				break;
			case 5:
				mbb = mb.sortMobilesAsperCompanyName();
				display(mbb);
				break;
			case 6:
				mbb = mb.showExpenceMobileForEachCompany();
				display(mbb);
				break;
			case 7:
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}

		} while (op != 6);

	}

	private static Mobile addMobileDetails(Company ic) {
		// TODO Auto-generated method stub
		System.out.println("enter company id");
		int id = sc.nextInt();
		System.out.println("enter Mobile Id");
		int mId = sc.nextInt();
		System.out.println("enter mobile model");
		String name = sc.next();
		System.out.println("enter rating");
		float model = sc.nextFloat();
		System.out.println("enter priec");
		double price = sc.nextDouble();
		Mobile im = new Mobile(ic, mId, name, model, price);
		return im;
	}

	private static Company addCompanyDeatils() {
		// TODO Auto-generated method stub
		System.out.println("enter company id");
		int id = sc.nextInt();
		System.out.println("enter company name");
		String name = sc.next();
		System.out.println("address");
		String address = sc.next();
		Company ic = new Company(id, name, address);
		return ic;
	}

	private static void displayMobile(ArrayList<Company> cm) {
		// TODO Auto-generated method stub
		for (Company c : cm) {
			System.out.println(c);
		}

	}

	private static void display(ArrayList<Mobile> mbb) {
		// TODO Auto-generated method stub
		for (Mobile m : mbb) {
			System.out.println(m);
		}

	}

}
