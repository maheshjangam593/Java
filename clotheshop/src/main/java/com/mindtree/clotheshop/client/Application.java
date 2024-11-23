package com.mindtree.clotheshop.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.clotheshop.entity.Brand;
import com.mindtree.clotheshop.entity.Shop;
import com.mindtree.clotheshop.exception.ServiceException;
import com.mindtree.clotheshop.service.impl.ShopServiceImpl;
import com.mindtree.clotheshop.servicee.ShopService;

public class Application {
	static Scanner sc = new Scanner(System.in);
	static ShopService shop = new ShopServiceImpl();
	static ArrayList<Brand> brandList = new ArrayList<>();
	static ArrayList<Shop> shopList = new ArrayList<>();

	public static void main(String[] args) {
		int op = 0;
		do {
			op = displayMenu();
			switch (op) {
			case 1:
				String messege = addBrandToUser();
				System.out.println(messege);
				break;
			case 2:
				try {
					brandList = shop.sortBrandsBasedOnCount();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				display(brandList);
				break;
			case 3:
				try {
					shopList=shop.getShopsHavingBrandsMoreThan3();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				displayy(shopList);
				break;
			case 4:
				System.out.println("enter the Count to be Updated");
				int updatedCount=sc.nextInt();
				try {
					shop.updateCount(updatedCount);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (op != 5);
	}

	private static void displayy(ArrayList<Shop> shopList2) {
		// TODO Auto-generated method stub
		for ( Shop s: shopList2) {
			System.out.println(s);
		}
	}

	private static void display(ArrayList<Brand> brandList2) {
		// TODO Auto-generated method stub
		for (Brand brand : brandList2) {
			System.out.println(brand);
		}
	}

	private static String addBrandToUser() {
		// TODO Auto-generated method stub
		System.out.println("enter brand Id");
		int brandId = sc.nextInt();
		String messege = "added brand to Shop";
		try {
			Brand brand = shop.isBranIdExist(brandId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enter Shop Id");
		int shopId = sc.nextInt();
		try {
			Shop sh = shop.getShopId(shopId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messege;
	}

	private static int displayMenu() {
		// TODO Auto-generated method stub

		System.out.println("1.add Brand to user");
		System.out.println("2.sort brand based on no of clothes");
		System.out.println("3. dislpay shop which has brands more than 3");
		System.out.println("4. update clothes if number of cloths is less than 2");
		System.out.println("5. Exit");
		return sc.nextInt();
	}
}
