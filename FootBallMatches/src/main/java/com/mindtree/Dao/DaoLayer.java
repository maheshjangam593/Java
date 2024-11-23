package com.mindtree.Dao;

import java.util.ArrayList;

import com.mindtree.entity.Match;
import com.mindtree.entity.Team;

public interface DaoLayer {

	void insertMatchDetails(Match match);

	ArrayList<Match> getTeamDetails(String str);

	ArrayList<Team> getTeamDetails();

}
