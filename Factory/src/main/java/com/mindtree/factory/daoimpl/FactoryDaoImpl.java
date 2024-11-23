package com.mindtree.factory.daoimpl;

import java.sql.SQLException;

import com.midtree.factory.dao.FactoryDaoInterface;
import com.mindtree.factory.entity.Factory;
import com.mindtree.factory.utility.Validations;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FactoryDaoImpl implements FactoryDaoInterface{

	public void saveFactoryDetails(Factory factory) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		con=(Connection) Validations.Connectivity();
		String query="insert into factory values (?,?,?,?)";
		ps=(PreparedStatement) con.prepareStatement(query);
		ps.setInt(1, factory.getFactoryId());
		ps.setString(2, factory.getName());
		ps.setString(3, factory.getLocation());
		ps.setString(4, factory.getItemManufactured());
		ps.executeLargeUpdate();
		
		ps.close();
		con.close();
		
	}

}
