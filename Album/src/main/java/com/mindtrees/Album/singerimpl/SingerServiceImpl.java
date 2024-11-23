package com.mindtrees.Album.singerimpl;

import java.util.ArrayList;
import com.mindtree.Album.entity.Singer;
import com.mindtree.album.exceptions.DaoException;
import com.mindtree.album.exceptions.ServiceException;
import com.mindtree.album.exceptions.SingerNotFOundException;
import com.mindtree.singerdaoimpl.SingerDaoImpl;
import com.mindtrees.Album.singerdao.SingerDao;
import com.mindtrees.Album.singerservice.SingerInterface;

public class SingerServiceImpl implements SingerInterface {
SingerDao dao=(SingerDao) new SingerDaoImpl();
	public String saveSinger(Singer singer) throws ServiceException {
		// TODO Auto-generated method stub
		
		try {
			return dao.saveSinger(singer);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}
	
	@Override
	public void getSinger(int sId) throws ServiceException {
		// TODO Auto-generated method stub
		ArrayList<Singer> singerList=new ArrayList<Singer>();
		try {
			singerList=dao.getSinger();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			throw new ServiceException(e1.getMessage());
		}
		boolean found=false;
		for(Singer si:singerList) {
			if(si.getSingerId()==sId) {
				found=true;
			}
		}
		if(!found) {
			try {
			throw new SingerNotFOundException("SingerNotFOund");
		}
		catch (SingerNotFOundException e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
		}
		
	}
	@Override
	public String deleteSinger(int sId) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return dao.deleteSinge(sId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
		throw new ServiceException(e.getMessage());
		}
	}

}
