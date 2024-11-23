package com.mindtree.entity;

public class Team {
	private String teamName;
	private String teamCity;
	
	public Team(String firstTeamName) {
		this.teamName=firstTeamName;
	}
	public Team(String teamName,String teamCity) {
		super();
		this.teamName = teamName;
		this.teamCity = teamCity;
		
	}
	public Team() {
		// TODO Auto-generated constructor stub
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCity() {
		return teamCity;
	}
	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", teamCity=" + teamCity + "]";
	}
	
	

	

	

}
