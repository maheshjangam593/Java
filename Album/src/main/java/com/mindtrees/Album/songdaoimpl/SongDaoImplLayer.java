package com.mindtrees.Album.songdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.Album.entity.Singer;
import com.mindtree.Album.entity.Song;
import com.mindtree.Album.exceptions.ConnectionFailedException;
import com.mindtree.Album.exceptions.DaoException;
import com.mindtree.Album.utility.JDBCConnection;
import com.mindtrees.Album.songdao.SongDao;

public class SongDaoImplLayer implements SongDao {

	@Override
	public String saveSong(Song song) throws DaoException {
		
		String messege = "";
		Connection con = null;
		PreparedStatement ps = null;

		int count = 0;
		String query = "insert into song values(?,?,?,?)";
		try {
			con = JDBCConnection.Connectivity();

			ps = con.prepareStatement(query);

			ps.setInt(1, song.getSongId());

			ps.setString(2, song.getTitle());
			ps.setFloat(3, song.getRating());
			ps.setInt(4, song.getSinger().getSingerId());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
		finally {
			JDBCConnection.closeResource(ps);
			JDBCConnection.closeResource(con);
			
		}
		if (count > 0) {
			messege = "Inserted Sunccesfully";
		}

		return messege;
	}

	@Override
	public ArrayList<Song> sortSongsBasedOnTitle() throws DaoException {
		// TODO Auto-generated method stub
		ArrayList<Song> songList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from song";
		try {
			con = JDBCConnection.Connectivity();

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				songList.add(new Song(rs.getInt(1), rs.getString(2), rs.getFloat(3), new Singer(rs.getInt(4))));
			}

		} catch (ConnectionFailedException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage());
		}
		return songList;
	}

	public ArrayList<Song> getSongsAboveGivenRating(float rating) throws DaoException {
		// TODO Auto-generated method stub
		ArrayList<Song> songList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from song where rating>" + rating;
		try {
			con = JDBCConnection.Connectivity();

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				songList.add(new Song(rs.getInt(1), rs.getString(2), rs.getFloat(3), new Singer(rs.getInt(4))));
			}

		} catch (ConnectionFailedException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage());
		}
		return songList;

	}

}
