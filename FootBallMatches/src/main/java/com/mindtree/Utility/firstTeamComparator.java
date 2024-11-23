package com.mindtree.Utility;

import java.util.Comparator;

import com.mindtree.entity.Match;

public class firstTeamComparator implements Comparator<Match> {

	@Override
	public int compare(Match o1, Match o2) {
		// TODO Auto-generated method stub
		return o1.getFirstTeamScore() > o2.getFirstTeamScore() ? 1
				: o1.getFirstTeamScore() < o2.getFirstTeamScore() ? -1 : 0;
	}

}
