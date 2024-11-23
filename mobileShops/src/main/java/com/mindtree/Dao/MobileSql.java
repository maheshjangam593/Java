package com.mindtree.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobileShops.Mobile;

public interface MobileSql {
	abstract Mobile insertIntoTable(Mobile mobile) throws SQLException;
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub

	abstract ArrayList<Mobile> sortByPrice(ArrayList<Mobile> shop) throws SQLException;
	// TODO Auto-generated method stub

	abstract ArrayList<Mobile> getDetailsStartWithCharAndRating(ArrayList<Mobile> shop, char ch, float rating);

	// TODO Auto-generated method stub

}
