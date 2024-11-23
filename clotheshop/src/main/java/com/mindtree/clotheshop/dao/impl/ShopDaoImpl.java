package com.mindtree.clotheshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.clotheshop.daoo.ShopDao;
import com.mindtree.clotheshop.entity.Brand;
import com.mindtree.clotheshop.entity.Shop;
import com.mindtree.clotheshop.exception.ConnectionFailedException;
import com.mindtree.clotheshop.exception.DaoException;
import com.mindtree.clotheshop.utility.JDBCConnection;

public class ShopDaoImpl implements ShopDao {

	public Brand getBrandId(int brandId) throws DaoException {
		// TODO Auto-generated method stub
		Brand brand = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from brand where brandId=" + brandId;
		try {
			con = JDBCConnection.Connectivity();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				brand = new Brand(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}

		} catch (SQLException e) {
			throw new DaoException("connection Failed");
		}
		return brand;
	}
	public Shop getShopId(int shopId) throws DaoException {
		// TODO Auto-generated method stub
		Brand brand = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Shop shop = null;
		String query = "select * from shop where shop_Id=" + shopId;
		try {
			con = JDBCConnection.Connectivity();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				shop = new Shop(rs.getInt(1), rs.getString(2));
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		} catch (ConnectionFailedException e) {
			throw new DaoException(e.getMessage());
		}
		return shop;
	}

	@Override
	public ArrayList<Brand> sortBrandsBasedOnCount() throws DaoException {
		// TODO Auto-generated method stub
		ArrayList<Brand> brandList = new ArrayList<>();
		Brand brand = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from brand";
		try {
			con = JDBCConnection.Connectivity();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				brandList.add(new Brand(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			throw new DaoException("connection Failed");
		} catch (ConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brandList;
	}

	@Override
	public ArrayList<Shop> getShopsHavingBrandsMoreThan3() throws DaoException {
		// TODO Auto-generated method stub
		ArrayList<Shop> shopList = new ArrayList<>();
		Brand brand = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select s.shop_Id from shop s join brand b on s.shop_Id=b.shop_Id group by s.shop_Id having count(b.brandId)>"
				+ 3;
		try {
			con = JDBCConnection.Connectivity();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				shopList.add(new Shop(rs.getInt(1)));
			}

		} catch (SQLException e) {
			throw new DaoException("connection Failed");
		} catch (ConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shopList;
	}

	@Override
	public void updateCount(int updatedCount) throws DaoException {
		// TODO Auto-generated method stub
		ArrayList<Brand> brandList = new ArrayList<>();

		Brand brand = null;
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;

		try {
			//String query = "insert into brand values(?,?,?,?)";
			// String query = "update brand set clothCount=" + updatedCount + " where
			// clothCount=" + 5;
		String query1 = "update brand set clothCount=" + updatedCount + " where clothCount>" + 5;

			con = JDBCConnection.Connectivity();
			//ps = con.prepareStatement(query);
			/*
			 * ps.setInt(1, 108); ps.setString(2, "skdjf"); ps.setInt(3, 12); ps.setInt(4,
			 * 2); ps.executeUpdate(query);
			 */
			ps2 = con.prepareStatement(query1);

			ps2.executeUpdate(query1);
			/*
			 * while (rs.next()) { brandList.add(new Brand(rs.getInt(1), rs.getString(2),
			 * rs.getInt(3))); }
			 */

		} catch (SQLException e) {
			throw new DaoException("connection Failed");
		} catch (ConnectionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
