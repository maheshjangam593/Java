package coom.mindtree.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.mobileShops.Mobile;
import com.mindtree.services.MobileServices;
import com.mindtree.utilities.Validations;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mindtree.Dao.MobileSql;

public class MobileSqlImpl implements MobileServices {

	public Mobile insertIntoTable(Mobile mobile) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		con = Validations.Connectivity();
		String query = "insert into Mobile values(?,?,?,?);";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, mobile.getId());
		ps.setString(2, mobile.getName());
		ps.setFloat(3, mobile.getRating());
		ps.setFloat(4, mobile.getPrice());
		ps.executeUpdate();
		Validations.closeResourse(con);
		return mobile;
	}

	public ArrayList<Mobile> sortByPrice(ArrayList<Mobile> shop) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Validations.Connectivity();
		String query = "select * from Mobile order by price;";
		Statement st = (Statement) con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			shop.add(new Mobile(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4)));
		}
		return shop;
	}

	public ArrayList<Mobile> getDetailsStartWithCharAndRating(ArrayList<Mobile> shop, char ch, float ratings)
			throws SQLException {
		// TODO Auto-generated method stub
		Connection con = Validations.Connectivity();
		String query2 = "select * from Mobile where name like '" + ch + "%' and rating>" + ratings + ";";
		Statement st = (Statement) con.createStatement();
		ResultSet rs = st.executeQuery(query2);
		while (rs.next()) {
			shop.add(new Mobile(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4)));
		}

		return shop;
	}

	@Override
	public ArrayList<Mobile> startWithCharAndRating(ArrayList<Mobile> shop) throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<Mobile> sortMobilesByPrice(ArrayList<Mobile> shop) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mobile> enterDeatils(ArrayList<Mobile> shop) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
