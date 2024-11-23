package com.mindtrees.Album.songservice;

import java.util.ArrayList;

import com.mindtree.Album.entity.Song;
import com.mindtree.Album.exceptions.ServiceException;

public interface SongInterface {

	String saveSong(Song song) throws ServiceException;

	ArrayList<Song> sortSongsBasedOnTitle() throws ServiceException;

	ArrayList<Song> getSongsAboveGivenRating(float rating) throws ServiceException;

}
