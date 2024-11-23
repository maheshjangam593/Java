package com.mindtree.factory.service;

import java.sql.SQLException;

import com.mindtree.factory.entity.Factory;

public interface FactoryDetailsServiceInterface {

	void enterFactoryDetails(Factory factory) throws SQLException;

}
