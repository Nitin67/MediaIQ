package com.topcoder;

public class Time {

	public static String whatTime(int seconds)
	{
		String str="";
		if(seconds>=3600)
		{	str+=seconds/3600+":";
			seconds=seconds%3600;
		}
		else
			str+=0+":";
		
		
		if(seconds>=60){
			str+=seconds/60+":";
			seconds=seconds%60;
		}
		else
			str+=0+":";
		
		str+=seconds;
		return str;
	}
}
