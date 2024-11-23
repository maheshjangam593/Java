package com.mindtree.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.entities.Admin;
import com.mindtree.utility.Validations;

public class FoodDaoImpl implements FoodDaoInterface {

	@Override
	public void insertAdminIntoTable(Admin ad) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement st=null;
		con=(Connection) Validations.Connectivity();
		System.out.println("conneceteed");
		String query="insert into admin values (?,?,?);";
		st=con.prepareStatement(query);
		st.setInt(1, ad.getAdminId());
		st.setString(2, ad.getAdminName());
		st.setString(3, ad.getPassword());
		st.executeUpdate();
		System.out.println("inserted");
		st.close();
		con.close();
		
		
		
	}

	@Override
	public boolean isExist(int id) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Admin> li=new ArrayList<>();
				Connection con=null;
				PreparedStatement st=null;
				ResultSet rs=null;
				con=(Connection) Validations.Connectivity();
				System.out.println("conneceteed");
				String query="select * from admin;";
				st=con.prepareStatement(query);
				rs=st.executeQuery();
				
				
		return false;
	}
	

	

}
