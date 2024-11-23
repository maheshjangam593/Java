package com.mindtree.ServiceImpl;

import java.sql.SQLException;

import com.mindtree.Dao.FoodDaoImpl;
import com.mindtree.Dao.FoodDaoInterface;
import com.mindtree.entities.Admin;

public class AdminOperations {
	FoodDaoInterface db=new FoodDaoImpl();
	public void counterAvailable() {
		// TODO Auto-generated method stub

	}

	public void totalFood() {
		// TODO Auto-generated method stub

	}

	public void ListOfCustomer() {
		// TODO Auto-generated method stub

	}

	public void NoOfCounterCreated() {
		// TODO Auto-generated method stub

	}

	public void removeFooditem() {
		// TODO Auto-generated method stub

	}

	public void ParticularCustomer() {
		// TODO Auto-generated method stub

	}

	public void logout() {
		// TODO Auto-generated method stub

	}

	public void insertAdmin(Admin ad) throws SQLException {
		// TODO Auto-generated method stub
		db.insertAdminIntoTable(ad);
		
	}

	public boolean isExist(int id) throws SQLException {
		// TODO Auto-generated method stub
		return db.isExist(id);
	}

}
