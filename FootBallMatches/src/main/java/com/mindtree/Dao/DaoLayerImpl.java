package com.mindtree.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.mindtree.Utility.Validations;
import com.mindtree.entity.Match;
import com.mindtree.entity.Team;

public class DaoLayerImpl implements DaoLayer {

	@Override
	public void insertMatchDetails(Match match) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validations.Connectivity();
			String query = "insert into matches values(?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, match.getMatchId());
			ps.setTimestamp(2, new Timestamp(match.getMatchDate().getTime()));
			ps.setInt(3, match.getFirstTeamScore());
			ps.setInt(4, match.getSecondTeamScore());
			ps.setString(5, match.getFirstTeam().getTeamName());
			ps.setString(6, match.getSecondTeam().getTeamName());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public ArrayList<Match> getTeamDetails(String str) {
		// TODO Auto-generated method stub
		ArrayList<Match> matchList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validations.Connectivity();
			String query = "select * from matches  where firsTeamName='" + str + "';";
			PreparedStatement statement;
			statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				matchList.add(new Match(rs.getInt(1), (new Date(rs.getTimestamp(2).getTime())), rs.getInt(3),
						rs.getInt(4), (new Team(rs.getString(5))), (new Team(rs.getString(6)))));

			}
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return matchList;
	}

	@Override
	public ArrayList<Team> getTeamDetails() {
		// TODO Auto-generated method stub
		ArrayList<Team> teamList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Validations.Connectivity();

			String query = "select * from teams";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teamList.add(new Team(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teamList;
	}

}
