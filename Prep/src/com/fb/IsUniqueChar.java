package com.fb;

import java.util.Arrays;

public class IsUniqueChar {

	public static boolean isUniqueChars(String str)
	{
		boolean []charSet=new boolean[256];
		for(int i=0;i<str.length();i++)
		{
			int val=str.charAt(i);
			if(charSet[val])
				return false;
			charSet[val]=true;
		}
		return true;
	}
	
	public static boolean isUniqueCharsWithOutExtraSpace(String str)
	{
		int checked=0;
		for(int i=0;i<str.length();i++)
		{
			int val=str.charAt(i);
			if( ( checked & (1<<val)) > 0)
				return false;
			checked |=(1<<val);
		}
		return true;
	}
	public static boolean isUniqueCharsWithSort(String str)
	{
		char []strArray=str.toCharArray();
		Arrays.sort(strArray);
		for(int i=0;i<str.length()-1;i++)
		{
			if(strArray[i]==strArray[i+1])
				return false;
		}
		return true;
	}
	
	public static void main(String []args)
	{
		System.out.println(isUniqueChars("Nitin"));
		System.out.println(isUniqueCharsWithOutExtraSpace("N*t*n"));
		System.out.println(isUniqueCharsWithSort("Nitin"));
	}
}
