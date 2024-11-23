package com.mindtree.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mindtree.Dao.DaoInterface;
import com.mindtree.Dao.MobileShopDao;

import com.mindtree.Exception.DaoImplException;
import com.mindtree.Exception.ServiceImplException;
import com.mindtree.mobileShop.entity.Company;
import com.mindtree.mobileShop.entity.Mobile;

public class MobileServiceImpl implements MobileInterface {
	DaoInterface dl = (DaoInterface) new MobileShopDao();

	@Override
	public ArrayList<Mobile> showMobilesAsperComapnyName(String name) {
		// TODO Auto-generated method stub
		ArrayList<Mobile> l = new ArrayList<>();
		try {
			l = dl.showMobilesAsperComapnyName(name);
		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public ArrayList<Mobile> sortMobilesByPriceandRating() {
		// TODO Auto-generated method stub
		ArrayList<Mobile> mb = new ArrayList<>();
		try {
			mb = dl.sortMobilesByPriceandRating();
		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(mb, Comparator.comparing(Mobile::getPrice).thenComparing(Mobile::getRating));
		return mb;
	}

	@Override
	public ArrayList<Mobile> showExpenceMobileForEachCompany() {
		// TODO Auto-generated method stub
		ArrayList<Mobile> l = new ArrayList<>();
		try {
			l = dl.showExpenceMobileForEachCompany();
		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public ArrayList<Company> addCompanyDeatils(Company ic) {
		// TODO Auto-generated method stub
		ArrayList<Company> l = new ArrayList<>();
		try {
			l = dl.inertCompanydetails(ic);

		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void addMobileDetails(Mobile im) throws ServiceImplException {
		// TODO Auto-generated method stub
		try {
			dl.insertMobiles(im);
		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			throw new ServiceImplException();
		}

	}

	@Override
	public ArrayList<Company> getCompanyDetails() {
		// TODO Auto-generated method stub
		try {
			return dl.getCompanyDetails();
		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Mobile> sortMobilesAsperCompanyName() {
		// TODO Auto-generated method stub
		ArrayList<Mobile> l = new ArrayList<>();
		try {
			l = dl.getSorteByCompanyName();
		} catch (DaoImplException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
