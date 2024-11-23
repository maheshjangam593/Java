package com.mindtree.entity;

import java.util.Date;

public class Match {
	private int matchId;
	private Date matchDate;
	private int firstTeamScore;
	private int secondTeamScore;
	private Team firstTeam;
	private Team secondTeam;

	public Match(int matchId, java.util.Date date, int firstTeamScore, int secondTeamScore, Team firstTeam,
			Team secondTeam) {
		super();
		this.matchId = matchId;
		this.matchDate = (Date) date;
		this.firstTeamScore = firstTeamScore;
		this.secondTeamScore = secondTeamScore;
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public int getFirstTeamScore() {
		return firstTeamScore;
	}

	public void setFirstTeamScore(int firstTeamScore) {
		this.firstTeamScore = firstTeamScore;
	}

	public int getSecondTeamScore() {
		return secondTeamScore;
	}

	public void setSecondTeamScore(int secondTeamScore) {
		this.secondTeamScore = secondTeamScore;
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(Team firstTeam) {
		this.firstTeam = firstTeam;
	}

	public Team getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(Team secondTeam) {
		this.secondTeam = secondTeam;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", matchDate=" + matchDate + ", firstTeamScore=" + firstTeamScore
				+ ", secondTeamScore=" + secondTeamScore + ", firstTeam=" + firstTeam + ", secondTeam=" + secondTeam
				+ "]";
	}

}
