package com.mindtree.factory.exeption;

import java.util.ArrayList;

import com.mindtree.factory.entity.Item;

public class NoFactoryFoundException  extends FactoryServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoFactoryFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoFactoryFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public NoFactoryFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public NoFactoryFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoFactoryFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
