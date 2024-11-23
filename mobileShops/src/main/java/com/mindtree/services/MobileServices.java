/**
 * 
 */
package com.mindtree.services;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mindtree.mobileShops.Mobile;

public interface MobileServices {
	abstract  ArrayList<Mobile>  startWithCharAndRating(ArrayList<Mobile> shop) throws SQLException;

	abstract ArrayList<Mobile> sortMobilesByPrice(ArrayList<Mobile> shop) throws SQLException;

	abstract ArrayList<Mobile> enterDeatils(ArrayList<Mobile> shop) throws SQLException;

}
