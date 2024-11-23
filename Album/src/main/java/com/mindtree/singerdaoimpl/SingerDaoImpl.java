package com.mindtree.singerdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.Album.entity.Singer;
import com.mindtree.Album.exceptions.ConnectionFailedException;
import com.mindtree.Album.exceptions.DaoException;
import com.mindtree.Album.utility.JDBCConnection;
import com.mindtrees.Album.singerdao.SingerDao;

public class SingerDaoImpl implements SingerDao {

	public String saveSinger(Singer singer) throws DaoException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String messege = "";
		int count = 0;
		String query = "insert into singer values(?,?)";
		try {
			con = JDBCConnection.Connectivity();

			ps = con.prepareStatement(query);

			ps.setInt(1, singer.getSingerId());

			ps.setString(2, singer.getName());
			count = ps.executeUpdate();
		} catch (ConnectionFailedException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage());
		}
		if (count > 0) {
			messege = "Inserted Sunccesfully";
		}

		return messege;
	}

	public ArrayList<Singer> getSinger() throws DaoException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement ps = null;
		ResultSet rs = null;
		ArrayList<Singer> singerList = new ArrayList<>();
		String query = "select * from singer";
		try {
			con = JDBCConnection.Connectivity();

			ps = con.createStatement();
			rs = ps.executeQuery(query);
			while (rs.next()) {
				singerList.add(new Singer(rs.getInt(1), rs.getString(2)));
			}

		} catch (ConnectionFailedException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}

		return singerList;
	}

	@Override
	public String deleteSinge(int sId) throws DaoException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String messege = "";
		int count = 0;
		String query = "delete from singer where singer_Id=" + sId;
		try {
			con = JDBCConnection.Connectivity();
			try {
				ps = con.prepareStatement(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DaoException(e);
			}
		} catch (ConnectionFailedException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		if (count > 0) {
			messege = "Deleted Sunccesfully";
		}

		return messege;
	}

}
