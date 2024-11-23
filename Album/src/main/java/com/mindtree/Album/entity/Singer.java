package com.mindtree.Album.entity;

import java.util.ArrayList;

public class Singer {
	private int singerId;
	private String name;
	private ArrayList<String> songs;

	public Singer() {

	}

	public Singer(int singerId, String name, ArrayList<String> songs) {
		super();
		this.singerId = singerId;
		this.name = name;
		this.songs = songs;
	}

	public Singer(int id, String name2) {
		// TODO Auto-generated constructor stub
		this.singerId =id;
		this.name = name2;
	}

	public Singer(int singerId) {
		super();
		this.singerId = singerId;
	}

	
	

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<String> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "singerId=" + singerId ;
	}

}
