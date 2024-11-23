package com.mindtrees.Album.singerservice;

import com.mindtree.Album.entity.Singer;
import com.mindtree.album.exceptions.ServiceException;

public interface SingerInterface {

	String saveSinger(Singer singer) throws ServiceException;

	void getSinger(int sId) throws ServiceException ;

	String deleteSinger(int sId) throws ServiceException;

}
