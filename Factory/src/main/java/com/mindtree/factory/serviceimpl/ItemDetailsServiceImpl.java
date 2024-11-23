package com.mindtree.factory.serviceimpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.midtree.factory.dao.ItemDaoInterface;
import com.mindtree.factory.daoimpl.ItemDaoImpl;
import com.mindtree.factory.entity.Item;
import com.mindtree.factory.exeption.FactoryServiceException;
import com.mindtree.factory.exeption.NoFactoryFoundException;
import com.mindtree.factory.service.ItemDetailsServiceInterface;
import com.mindtree.factory.utility.CountComparator;

public class ItemDetailsServiceImpl implements ItemDetailsServiceInterface{
ItemDaoInterface idao=(ItemDaoInterface) new ItemDaoImpl();
//NoFactoryFoundException nofact=new NoFactoryFoundException();
	public void insertItem(Item item) throws SQLException {
		// TODO Auto-generated method stub
		idao.insertItem(item);
	}
	public ArrayList<Item> deleteItem() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList=new ArrayList<>();
		 itemList=idao.deleteItem();
		return null;
	}
	public ArrayList<Item> sortByItemCount(String factoryName) throws SQLException, FactoryServiceException  {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList=new ArrayList<>();
		
		itemList=idao.sortByItemCount(factoryName);
		boolean found=true;
		try {
		for(Item it:itemList) {
			if(it.getFactory().getName().equalsIgnoreCase(factoryName)) {
				found=false;
			}
		}
		if(found) {
			throw new NoFactoryFoundException("FactoryNotFound");
		}
		}
		catch(NoFactoryFoundException e) {
			throw new FactoryServiceException(e.getMessage());
		}
		/*
		 * try { itemList=NofactoryFoundException(); } catch (NoFactoryFoundException e)
		 * { // TODO Auto-generated catch block throw new
		 * FactoryServiceException(e.getMessage()); }
		 */
		Collections.sort(itemList, new CountComparator());
		return itemList;
	}

}
