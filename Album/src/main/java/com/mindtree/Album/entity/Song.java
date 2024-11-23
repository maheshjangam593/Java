package com.mindtree.Album.entity;

public class Song {
	private int songId;
	private String title;
	private float rating;

	private Singer singer;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(int songId, String title, float rating, Singer singer) {
		super();
		this.songId = songId;
		this.title = title;
		this.rating = rating;
		this.singer = singer;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", title=" + title + ", rating=" + rating + ", singer=" + singer + "]";
	}

}
