package com.mindtree.Manager;

import java.util.ArrayList;
import java.util.Date;

import com.mindtree.Exceptions.ServiceException;
import com.mindtree.entity.Match;
import com.mindtree.entity.Team;

public interface FootBallMatchManager {

	void insertMatchDetails(Match match) throws ServiceException;

	ArrayList<Match> getTeamDetails(String str);

	ArrayList<Team> getTeamDetails();

	Date getDate(String pattern) throws ServiceException;

	int goalCheck(int firstTeamGoal) throws ServiceException;

}
