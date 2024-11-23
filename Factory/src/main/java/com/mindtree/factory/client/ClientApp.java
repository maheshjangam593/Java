package com.mindtree.factory.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.factory.entity.Factory;
import com.mindtree.factory.entity.Item;
import com.mindtree.factory.exeption.FactoryServiceException;
import com.mindtree.factory.service.FactoryDetailsServiceInterface;
import com.mindtree.factory.service.ItemDetailsServiceInterface;
import com.mindtree.factory.serviceimpl.FactoryDetailsServiceImpl;
import com.mindtree.factory.serviceimpl.ItemDetailsServiceImpl;

public class ClientApp {
	static Scanner sc = new Scanner(System.in);
	static FactoryDetailsServiceInterface factory = (FactoryDetailsServiceInterface) new FactoryDetailsServiceImpl();
	static ItemDetailsServiceInterface item = (ItemDetailsServiceInterface) new ItemDetailsServiceImpl();
	 

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList = new ArrayList<>();
		int op = 0;
		do {
			displayMenu();
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("enter foctory Id");
				int fId = sc.nextInt();
				sc.nextLine();
				System.out.println("enter Name");
				String fName = sc.next();
				System.out.println("enter location");
				String loaction = sc.next();
				System.out.println("enter ItemManufactured");
				String itemname = sc.next();
				factory.enterFactoryDetails(new Factory(fId, fName, loaction, itemname));
				System.out.println("Factory inserted");
				System.out.println("enter the number of items to add factory");
				int numberOfItems = sc.nextInt();
				for (int i = 0; i < numberOfItems; i++) {
					System.out.println("ENter itemId");
					int itemId = sc.nextInt();
					System.out.println("enter Item Name");
					String Iname = sc.next();
					System.out.println(" enter item produced Count");
					int Icount = sc.nextInt();
					item.insertItem(new Item((new Factory(fId, fName, loaction, itemname)), itemId, Iname, Icount));
				}
				break;
			case 2:
				itemList = item.deleteItem();
				displayRemainedItems(itemList);
				break;
			case 3:
				System.out.println("enter factory Name");
				String factoryName = sc.next();
				try {
					itemList = item.sortByItemCount(factoryName);
				} catch (FactoryServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				display(itemList);
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid option");
				break;
			}

		} while (op != 4);
	}
	private static void displayRemainedItems(ArrayList<Item> itemList2) {
		// TODO Auto-generated method stub
		for (Item item : itemList2) {
			System.out.println("factory id " + item.getFactory().getFactoryId() + " " + " item id " + item.getItemId()
					+ "item name" + item.getName() + " produced count" + item.getItemProducedCount());
		}

	}
	private static void display(ArrayList<Item> itemList2) {
		// TODO Auto-generated method stub
		for (Item it : itemList2) {
			System.out.println(it);
		}
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.enter Factory And Item details");
		System.out.println("2.Delete item which has produceCount is Zero");
		System.out.println("3.Show according to sorted itemProducedCount of a factory");
		System.out.println("4.exit");
		System.out.println("choose option");

	}

}
