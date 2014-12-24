package com.fb;

import java.util.Arrays;

public class RandomFunction {

	
	
	public static void main(String []args)
	{
		String str="helloworld";
		int loc[]={(int)(Math.random()*str.length()),(int)(Math.random()* str.length()),(int)(Math.random()*str.length())};
		Arrays.sort(loc);
		System.out.println(str.charAt(loc[0])+str.charAt(loc[1])+str.charAt(loc[2]));
	}
}
