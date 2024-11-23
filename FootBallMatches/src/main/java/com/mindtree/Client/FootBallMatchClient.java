package com.mindtree.Client;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import com.mindtree.Exceptions.ServiceException;
import com.mindtree.Manager.FootBallMatchManager;
import com.mindtree.Manager.Manger;
import com.mindtree.Utility.firstTeamComparator;
import com.mindtree.Utility.secondTeamComparator;
import com.mindtree.entity.Match;
import com.mindtree.entity.Team;

public class FootBallMatchClient {
	static Scanner sc = new Scanner(System.in);
	static FootBallMatchManager fbs = new Manger();
	static ArrayList<Match> matchList = new ArrayList<>();
	static ArrayList<Team> teamList = new ArrayList<>();
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		int op = 0;
		do {
			System.out.println("1.Add Match Details \n2.List all matches given team name\3.Exit");
			System.out.println("choose option");
			op = sc.nextInt();
			switch (op) {

			case 1:
				teamList = fbs.getTeamDetails();
				displayTeams(teamList);
				System.out.println("Enter Match ID :");
				int matchId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Match Date  in format MM-dd-yyyy HH-MM ");
				String matchDate = sc.nextLine();
				Date date = null;
				try {
					date = fbs.getDate(matchDate);
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				/*
				 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); Date date
				 * = (Date) simpleDateFormat.parse(matchDate);
				 */
				System.out.println("Select FirstTeam Name :");
				String firstTeamName = sc.next();

				System.out.println("Select SecondTeam Name :");
				String secondTeamName = sc.next();
				System.out.println("Enter FirstTeam Goal  :");
				int firstTeamGoal = sc.nextInt();
				try {
					firstTeamGoal = fbs.goalCheck(firstTeamGoal);
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
				System.out.println("Enter SecondTeam Goal :");
				int secondTeamGoal = sc.nextInt();
				try {
					secondTeamGoal = fbs.goalCheck(secondTeamGoal);
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
				Match match1 = new Match(matchId, date, firstTeamGoal, secondTeamGoal, new Team(firstTeamName),
						new Team(secondTeamName));

				try {
					fbs.insertMatchDetails(match1);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				Match match2 = new Match(matchId, date, secondTeamGoal, firstTeamGoal, new Team(secondTeamName),
						new Team(firstTeamName));
				try {
					fbs.insertMatchDetails(match2);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("enter team Name");
				String str = sc.next();
				matchList = fbs.getTeamDetails(str);
				System.out.println("Team name is " + str);
				Collections.sort(matchList, new firstTeamComparator());
				Collections.sort(matchList, new secondTeamComparator());

				display(matchList);
				break;
			case 3:
				break;
			default:
				System.out.println("Invaid Option");
				break;
			}

		} while (op != 3);
	}

	private static void display(ArrayList<Match> mt2) {
		// TODO Auto-generated method stub
		for (int i = mt2.size()-1; i >= 0; i--) {
			System.out.println(mt2.get(i).getMatchDate() + " " + mt2.get(i).getFirstTeamScore() + "-"
					+ mt2.get(i).getSecondTeamScore());
		}

	}

	private static void displayTeams(ArrayList<Team> tm2) {
		// TODO Auto-generated method stub
		for (Team t : tm2) {
			System.out.println(t);
		}

	}

}
