package com.mindtree.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.Exception.DaoImplException;
import com.mindtree.Exception.ServiceImplException;
import com.mindtree.mobileShop.entity.Company;
import com.mindtree.mobileShop.entity.Mobile;

public interface MobileInterface {

	ArrayList<Company> addCompanyDeatils(Company ic) throws SQLException, DaoImplException;

	void addMobileDetails(Mobile im) throws ServiceImplException;

	ArrayList<Mobile> showMobilesAsperComapnyName(String name) throws DaoImplException ;

	ArrayList<Mobile> sortMobilesByPriceandRating() throws DaoImplException;

	ArrayList<Mobile> showExpenceMobileForEachCompany() throws DaoImplException;

	ArrayList<Company> getCompanyDetails();

	ArrayList<Mobile> sortMobilesAsperCompanyName();



}
