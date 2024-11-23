package com.mindtree.Exceptions;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputMissMatchException extends ServiceException {

	public InputMissMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InputMissMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InputMissMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InputMissMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InputMissMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public static Date validateDate(String pattern) throws InputMissMatchException {
		// TODO Auto-generated method stub
		if (pattern.trim().equals("")) {
			throw new InputMissMatchException("It is invalid! re enter the date in (MM-DD-YYYY HH:MM):");
		} 
		else {
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy hh-mm");
			sdfrmt.setLenient(false);
			try {
				Date javaDate = (Date) sdfrmt.parse(pattern);
				return javaDate;

			} catch (ParseException e) {
				throw new InputMissMatchException("It is invalid! re enter the date in (DD-MM-YYYY HH:MM):");
			}
		}

	}

	public int goalCheck(int firstTeamGoal) throws InputMissMatchException {
		// TODO Auto-generated method stub
		if (firstTeamGoal < 0) {
			throw new InputMissMatchException("InvalidGoal");
		} else
			return firstTeamGoal;
		
	}
	

}
