package com.mindtrees.Album.singerdao;

import java.util.ArrayList;

import com.mindtree.Album.entity.Singer;
import com.mindtree.album.exceptions.DaoException;

public interface SingerDao {

	String saveSinger(Singer singer) throws DaoException ;

	ArrayList<Singer> getSinger() throws DaoException;

	String deleteSinge(int sId) throws DaoException;

}
