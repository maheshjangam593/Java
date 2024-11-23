package com.midtree.factory.dao;

import java.sql.SQLException;

import com.mindtree.factory.entity.Factory;

public interface FactoryDaoInterface {

	void saveFactoryDetails(Factory factory) throws SQLException;

}
