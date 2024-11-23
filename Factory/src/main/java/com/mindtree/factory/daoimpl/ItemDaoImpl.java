package com.mindtree.factory.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.midtree.factory.dao.ItemDaoInterface;
import com.mindtree.factory.entity.Factory;
import com.mindtree.factory.entity.Item;
import com.mindtree.factory.utility.Validations;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ItemDaoImpl implements ItemDaoInterface {

	public void insertItem(Item item) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		con = (Connection) Validations.Connectivity();
		String query = "insert into item values(?,?,?,?)";
		ps = (PreparedStatement) con.prepareStatement(query);
		ps.setInt(1, item.getFactory().getFactoryId());
		ps.setInt(2, item.getItemId());
		ps.setString(3, item.getName());
		ps.setInt(4, item.getItemProducedCount());
		ps.executeUpdate();

		ps.close();
		con.close();

	}

	public ArrayList<Item> deleteItem() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ArrayList<Item> itemList=new ArrayList<>();
		ResultSet rs=null;
		con = (Connection) Validations.Connectivity();
		String query = "delete from item where itemcount=0";
		ps=(PreparedStatement) con.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			itemList.add(new Item((new Factory(rs.getInt(1))), rs.getInt(2),rs.getString(3), rs.getInt(4)));
		}
		ps.close();
		con.close();
		return itemList;
	}
	@Override
	public ArrayList<Item> sortByItemCount(String factoryName) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Item> itemList=new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		con = (Connection) Validations.Connectivity();
		String query = "select * from item";
		ps=(PreparedStatement) con.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			itemList.add(new Item((new Factory(rs.getInt(1),rs.getString(2))),rs.getInt(3) ,rs.getString(4), rs.getInt(5)));
		}
		ps.close();
		con.close();
		rs.close();
		return itemList;
	}

}
