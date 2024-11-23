package com.mindtree.clotheshop.servicee;

import java.util.ArrayList;

import com.mindtree.clotheshop.entity.Brand;
import com.mindtree.clotheshop.entity.Shop;
import com.mindtree.clotheshop.exception.ServiceException;

public interface ShopService {

	

	Brand isBranIdExist(int brandId)throws ServiceException;

	Shop getShopId(int shopId) throws ServiceException;

	ArrayList<Brand> sortBrandsBasedOnCount() throws ServiceException;

	ArrayList<Shop> getShopsHavingBrandsMoreThan3() throws ServiceException;

	void updateCount(int updatedCount) throws ServiceException;
	
}
