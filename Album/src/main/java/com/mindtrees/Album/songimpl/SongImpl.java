package com.mindtrees.Album.songimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mindtree.Album.entity.Song;
import com.mindtree.Album.exceptions.DaoException;
import com.mindtree.Album.exceptions.ServiceException;
import com.mindtrees.Album.songdao.SongDao;
import com.mindtrees.Album.songdaoimpl.SongDaoImplLayer;
import com.mindtrees.Album.songservice.SongInterface;

public class SongImpl implements SongInterface, Comparator<Song> {

	SongDao daoo = new SongDaoImplLayer();

	@Override
	public String saveSong(Song song) throws ServiceException  {
		// TODO Auto-generated method stub
		try {
			return daoo.saveSong(song);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public ArrayList<Song> sortSongsBasedOnTitle() throws ServiceException {
		// TODO Auto-generated method stub
		ArrayList<Song> songList = new ArrayList<>();
		try {
			songList = daoo.sortSongsBasedOnTitle();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
		Collections.sort(songList, new SongImpl());

		return songList;
	}

	@Override
	public int compare(Song o1, Song o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareTo(o2.getTitle());
	}

	@Override
	public ArrayList<Song> getSongsAboveGivenRating(float rating) throws ServiceException {

		try {
			return  daoo.getSongsAboveGivenRating(rating);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}
}
