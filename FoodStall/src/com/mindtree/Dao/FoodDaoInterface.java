package com.mindtree.Dao;

import java.sql.SQLException;

import com.mindtree.entities.Admin;

public interface FoodDaoInterface {

	void insertAdminIntoTable(Admin ad) throws SQLException;

	boolean isExist(int id) throws SQLException;

}
