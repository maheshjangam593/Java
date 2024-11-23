package com.mindtree.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Dateee {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String str=sc.next();
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date dateee = (Date) simpleDateFormat.parse(str);
		System.out.println(dateee);
	}

}
