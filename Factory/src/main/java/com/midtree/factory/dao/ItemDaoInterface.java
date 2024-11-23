package com.midtree.factory.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.factory.entity.Item;

public interface ItemDaoInterface {

	void insertItem(Item item) throws SQLException;

	ArrayList<Item> deleteItem() throws SQLException;

	ArrayList<Item> sortByItemCount(String factoryName) throws SQLException;

}
