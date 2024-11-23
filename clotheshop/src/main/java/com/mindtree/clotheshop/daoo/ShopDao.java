package com.mindtree.clotheshop.daoo;

import java.util.ArrayList;

import com.mindtree.clotheshop.entity.Brand;
import com.mindtree.clotheshop.entity.Shop;
import com.mindtree.clotheshop.exception.DaoException;

public interface ShopDao {

	Brand getBrandId(int brandId) throws DaoException;

	Shop getShopId(int shopId) throws DaoException;

	ArrayList<Brand> sortBrandsBasedOnCount() throws DaoException;

	ArrayList<Shop> getShopsHavingBrandsMoreThan3() throws DaoException;

	void updateCount(int updatedCount) throws DaoException;

}
