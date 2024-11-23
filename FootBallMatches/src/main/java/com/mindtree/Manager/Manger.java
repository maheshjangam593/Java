package com.mindtree.Manager;

import java.util.Date;
import java.util.ArrayList;

import com.mindtree.Dao.DaoLayer;
import com.mindtree.Dao.DaoLayerImpl;
import com.mindtree.Exceptions.InputMissMatchException;
import com.mindtree.Exceptions.ServiceException;
import com.mindtree.entity.Match;
import com.mindtree.entity.Team;

public class Manger implements FootBallMatchManager {
	DaoLayer dl = new DaoLayerImpl();
	InputMissMatchException i = new InputMissMatchException();

	@Override
	public void insertMatchDetails(Match match) throws ServiceException {

		dl.insertMatchDetails(match);

	}

	@Override
	public ArrayList<Match> getTeamDetails(String str) {
		// TODO Auto-generated method stub
		ArrayList<Match> matchList = new ArrayList<>();
		matchList = dl.getTeamDetails(str);
		return matchList;
	}

	@Override
	public ArrayList<Team> getTeamDetails() {
		// TODO Auto-generated method stub
		return dl.getTeamDetails();
	}

	@Override
	public java.util.Date getDate(String pattern) throws ServiceException {
		// TODO Auto-generated method stub
		Date date = null;
		try {
			date = i.validateDate(pattern);
		} catch (InputMissMatchException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
		return date;
	}

	@Override
	public int goalCheck(int firstTeamGoal) throws ServiceException {
		// TODO Auto-generated method stub
		int goal=0;
			try {
				goal=i.goalCheck(firstTeamGoal);
			} catch (InputMissMatchException e) {
				// TODO Auto-generated catch block
				throw new ServiceException(e.getMessage());
			}
		return goal;
	}
}
