package com.mindtree.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.Exception.ConnectionException;
import com.mindtree.Exception.DaoImplException;
import com.mindtree.Utility.Validatons;
import com.mindtree.mobileShop.entity.Company;
import com.mindtree.mobileShop.entity.Mobile;

public class MobileShopDao implements DaoInterface {
	Validatons vi = new Validatons();

	@Override
	public void insertMobiles(Mobile im) throws DaoImplException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
		con = Validatons.Connectivity();
		String query = "insert into mobile values(?,?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1, im.getCompany().getCompanyId());
		ps.setInt(2, im.getMobileId());
		ps.setString(3, im.getModel());
		ps.setFloat(4, im.getRating());
		ps.setDouble(5, im.getPrice());
		ps.executeUpdate();
		}
		catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}
		
		
	}

	@Override
	public ArrayList<Mobile> showMobilesAsperComapnyName(String name) throws DaoImplException {
		// TODO Auto-generated method stub
		ArrayList<Mobile> mobileSet = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validatons.Connectivity();

			String query = "select  c.companyid,c.companyname , m. mobileid,m.model,m.rating ,m.price from mobile m inner join company c on m.companyId=c.companyId  where c.companyName='"
					+ name + "'";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mobileSet.add(new Mobile(new Company(rs.getInt(1), rs.getString(2)), rs.getInt(3), rs.getString(4),
						rs.getFloat(5), rs.getDouble(6)));
			}

		} catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}

		return mobileSet;
	}

	@Override
	public ArrayList<Company> inertCompanydetails(Company ic) throws SQLException, DaoImplException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Company> companyList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validatons.Connectivity();
		 
		String query = "insert into company values(?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1, ic.getCompanyId());
		ps.setString(2, ic.getCompanyName());
		ps.setString(3, ic.getCompanyAddress());
		ps.executeUpdate();
		con.close();
		ps.close();
		}
		catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}
		return companyList;
	}

	@Override
	public ArrayList<Company> getCompanyDetails() throws DaoImplException {
		// TODO Auto-generated method stub
		ArrayList<Company> companyList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validatons.Connectivity();

			String query = "select * from company;";

			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				companyList.add(new Company(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} 
		
		catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}
		return companyList;
	}

	@Override
	public ArrayList<Mobile> sortMobilesByPriceandRating() throws DaoImplException {
		// TODO Auto-generated method stub
		ArrayList<Mobile> mobileSet = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validatons.Connectivity();

			String query = "select * from mobile";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mobileSet.add(new Mobile(new Company(rs.getInt(1)), rs.getInt(2), rs.getString(3), rs.getFloat(4),
						rs.getDouble(5)));
			}

		} 
		catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}

		return mobileSet;

	}

	@Override
	public ArrayList<Mobile> showExpenceMobileForEachCompany() throws DaoImplException {
		// TODO Auto-generated method stub
		ArrayList<Mobile> mobileSet = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validatons.Connectivity();

			String query = "select c.companyName ,m.model,m.rating,max(m.price) from mobile m\r\n"
					+ "join company c on c.companyid=m.companyid group by c.companyname;";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mobileSet.add(
						new Mobile(new Company(rs.getString(1)), rs.getString(2), rs.getFloat(3), rs.getDouble(4)));
			}

		} 
		catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}

		return mobileSet;
	}

	@Override
	public ArrayList<Mobile> getSorteByCompanyName() throws DaoImplException {
		// TODO Auto-generated method stub
		ArrayList<Mobile> mobileSet = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validatons.Connectivity();

			String query = "select c.companyName ,m.model,m.rating,m.price from mobile m\r\n"
					+ "join company c on c.companyid=m.companyid order by c.companyname;";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mobileSet.add(
						new Mobile(new Company(rs.getString(1)), rs.getString(2), rs.getFloat(3), rs.getDouble(4)));
			}

		} catch(ConnectionException | SQLException e ) {
			throw new DaoImplException("connection Failed");
		}

		return mobileSet;

	}

}
