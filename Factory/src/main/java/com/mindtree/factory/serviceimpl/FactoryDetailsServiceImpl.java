package com.mindtree.factory.serviceimpl;

import java.sql.SQLException;

import com.midtree.factory.dao.FactoryDaoInterface;
import com.mindtree.factory.daoimpl.FactoryDaoImpl;
import com.mindtree.factory.entity.Factory;
import com.mindtree.factory.service.FactoryDetailsServiceInterface;

public class FactoryDetailsServiceImpl implements FactoryDetailsServiceInterface{
	FactoryDaoInterface fdao=new FactoryDaoImpl();
	public void enterFactoryDetails(Factory factory) throws SQLException {
		// TODO Auto-generated method stub
		
			this.fdao.saveFactoryDetails(factory);
			
			
	}

}
