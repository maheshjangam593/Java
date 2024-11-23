package com.mindtrees.Album.songdao;

import java.util.ArrayList;

import com.mindtree.Album.entity.Song;
import com.mindtree.album.exceptions.DaoException;

public interface SongDao {

	

	String saveSong(Song song) throws DaoException, com.mindtree.Album.exceptions.DaoException;

	ArrayList<Song> sortSongsBasedOnTitle() throws DaoException;

	ArrayList<Song> getSongsAboveGivenRating(float rating) throws DaoException;

}
