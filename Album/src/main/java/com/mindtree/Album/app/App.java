package com.mindtree.Album.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.Album.entity.Singer;
import com.mindtree.Album.entity.Song;
import com.mindtree.Album.exceptions.ServiceException;
import com.mindtrees.Album.singerimpl.SingerServiceImpl;
import com.mindtrees.Album.singerservice.SingerInterface;
import com.mindtrees.Album.songimpl.SongImpl;
import com.mindtrees.Album.songservice.SongInterface;

public class App {
	static SingerInterface si = new SingerServiceImpl();
	static SongInterface so = (SongInterface) new SongImpl();
	static Scanner sc = new Scanner(System.in);
	static List<Song> songList = new ArrayList<Song>();
	public static void main(String[] args) {
		int op = 0;
		do {
			op = displayMenu();
			switch (op) {
			case 1:
				String messege = addSinger();
				System.out.println(messege);
				break;
			case 2:
				messege = addSong();
				System.out.println(messege);
				break;
			case 3:
				songList = sortSongsBasedOnTitle();
				displaySongs(songList);
				break;
			case 4:
				songList = getSongsAboveGivenRating();
				displaySongs(songList);
				break;
			case 5:
				messege = isDeleted();
				System.out.println(messege);
				break;
			case 6:
				sc.close();
				break;
			default:
				System.out.println("Invalid Option");

				break;
			}

		} while (op != 6);
	}

	private static List<Song> getSongsAboveGivenRating() {

		System.out.println("enter rating");
		float rating = sc.nextFloat();
		try {
			songList = so.getSongsAboveGivenRating(rating);
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}

		return songList;
	}

	private static String isDeleted() {

		System.out.println("enter Id to be deleted");
		int sId = sc.nextInt();
		String messege = "";
		try {
			messege = si.deleteSinger(sId);
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
		return messege;
	}

	private static void displaySongs(List<Song> songList2) {

		for (Song song : songList2) {
			System.out.println(song);
		}

	}

	private static List<Song> sortSongsBasedOnTitle() {
		try {
			songList = so.sortSongsBasedOnTitle();
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
		return songList;

	}

	private static String addSong() {

		System.out.println("enter song id");
		int id = sc.nextInt();
		System.out.println("enter title");
		String title = sc.next();
		System.out.println("enter rating");
		float rating = sc.nextFloat();
		System.out.println("enter singer Id");
		int sId = sc.nextInt();

		try {
			si.getSinger(sId);
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}

		Song song = new Song(id, title, rating, new Singer(sId));
		String messege = "";
		try {
			messege = so.saveSong(song);
		} catch (ServiceException e) {

			System.out.println(e.getMessage());
		}
		return messege;

	}

	private static String addSinger() {
		System.out.println("enter id");
		int id = (sc.nextInt());
		sc.nextLine();
		System.out.println("enter name");
		String name = sc.next();
		Singer singer = new Singer(id, name);
		String messege = "";
		try {
			messege = si.saveSinger(singer);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return messege;
	}
	private static int displayMenu() {
		System.out.println("1.add singer");
		System.out.println("2.add song");
		System.out.println("3.sort songs based on title");
		System.out.println("4.display song above given rating");
		System.out.println("5.delete singer");
		System.out.println("6.exit");
		System.out.println("enter option");
		return sc.nextInt();
	}

}
