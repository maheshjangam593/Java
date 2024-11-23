package com.mindtree.clotheshop.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mindtree.clotheshop.dao.impl.ShopDaoImpl;
import com.mindtree.clotheshop.daoo.ShopDao;
import com.mindtree.clotheshop.entity.Brand;
import com.mindtree.clotheshop.entity.Shop;
import com.mindtree.clotheshop.exception.BrandNotFoundException;
import com.mindtree.clotheshop.exception.DaoException;
import com.mindtree.clotheshop.exception.ServiceException;
import com.mindtree.clotheshop.exception.ShopNotFoundException;
import com.mindtree.clotheshop.servicee.ShopService;

public class ShopServiceImpl implements ShopService, Comparator<Brand> {
	ShopDao dao = new ShopDaoImpl();

	public Brand isBranIdExist(int brandId) throws ServiceException {
		// TODO Auto-generated method stub
		Brand brand = null;
		try {
			brand = dao.getBrandId(brandId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
		try {
			if (brand == null) {
				throw new BrandNotFoundException("Brand Not Found");
			} else {
				return brand;
			}
		} catch (BrandNotFoundException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public Shop getShopId(int shopId) throws ServiceException {
		// TODO Auto-generated method stub
		Shop shop = null;

		try {
			shop = dao.getShopId(shopId);
			if (shop == null) {
				throw new ShopNotFoundException("Shop not found");
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}

		catch (ShopNotFoundException e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
		return shop;
	}

	@Override
	public ArrayList<Brand> sortBrandsBasedOnCount() throws ServiceException {
		// TODO Auto-generated method stub
		ArrayList<Brand> brandList = new ArrayList<>();
		try {
			brandList = dao.sortBrandsBasedOnCount();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
		Collections.sort(brandList, new ShopServiceImpl());

		return brandList;
	}

	@Override
	public int compare(Brand o1, Brand o2) {
		// TODO Auto-generated method stub
		return o1.getClothCount() > o2.getClothCount() ? 1 : o1.getClothCount() < o2.getClothCount() ? -1 : 0;
	}

	@Override
	public ArrayList<Shop> getShopsHavingBrandsMoreThan3() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return dao.getShopsHavingBrandsMoreThan3();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}
	@Override
	public void updateCount(int updatedCount) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			dao.updateCount(updatedCount);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}

	}

}
