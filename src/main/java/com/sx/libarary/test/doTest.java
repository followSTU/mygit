package com.sx.libarary.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class doTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");  

		Date date = new Date();  

		Calendar c = Calendar.getInstance();  

		c.setTime(date);  

		c.add(Calendar.DATE, 30);  

		System.out.println(c.getTime()); 
	}

}
