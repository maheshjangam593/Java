package com.mindtree.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.Exception.DaoImplException;
import com.mindtree.mobileShop.entity.Company;
import com.mindtree.mobileShop.entity.Mobile;

public interface DaoInterface {

	ArrayList<Company> inertCompanydetails(Company ic) throws SQLException, DaoImplException;

	ArrayList<Mobile> showMobilesAsperComapnyName(String name) throws DaoImplException;

	void insertMobiles(Mobile im) throws DaoImplException;

	ArrayList<Company> getCompanyDetails() throws DaoImplException;

	ArrayList<Mobile> sortMobilesByPriceandRating() throws DaoImplException;

	ArrayList<Mobile> showExpenceMobileForEachCompany() throws DaoImplException;

	ArrayList<Mobile> getSorteByCompanyName() throws DaoImplException;

}
