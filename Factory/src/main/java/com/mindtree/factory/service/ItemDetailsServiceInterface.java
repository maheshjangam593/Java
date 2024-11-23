package com.mindtree.factory.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.factory.entity.Item;
import com.mindtree.factory.exeption.FactoryServiceException;

public interface ItemDetailsServiceInterface {

	void insertItem(Item item) throws SQLException;

	ArrayList<Item> deleteItem() throws SQLException;

	ArrayList<Item> sortByItemCount(String factoryName) throws SQLException, FactoryServiceException;

}
