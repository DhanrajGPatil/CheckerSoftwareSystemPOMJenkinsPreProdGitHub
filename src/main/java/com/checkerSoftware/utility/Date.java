package com.checkerSoftware.utility;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
	
	public static String systemTime() {
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		return date;
		
	}

}
