package com.fb;

import java.util.Arrays;

public class CheckAnagram {
	
	public static boolean isAnagram(String str,String str1)
	{
		if(str.length()!=str1.length())
			return false;
		char []strArray=str.toCharArray();
		char []str1Array=str1.toCharArray();
		Arrays.sort(strArray);
		Arrays.sort(str1Array);
		for(int i=0;i<str1.length();i++)
		{
			if(str1Array[i]!=strArray[i])
				return false;
		}
		return true;
			
	}
	
	public static boolean isAnagramOrderN(String str,String str1)
	{
		char []strArray=str.toCharArray();
		int letters[]=new int[256];
		int numOfUniqueChars=0;
		//int numOfUniqueFound=0;
		for(char c: strArray)
		{
			if(letters[c]==0)
				numOfUniqueChars++;
			letters[c]++;
		}
		for(int i=0;i<str1.length();i++)
		{
			if(letters[str1.charAt(i)]==0)
				return false;
			
			letters[str1.charAt(i)]--;
			
			if(letters[str1.charAt(i)]==0)
			{
				numOfUniqueChars--;
				if(numOfUniqueChars==0)
				{
					return i==(str1.length()-1);
				}
			}
			
		}
		
		return true;
	}
	
	
	public static void main(String []args)
	{
		String str="cat";
		String str1="tac";
		if(isAnagram(str, str1))
			System.out.println("Anagram");
		else
			System.out.println("Not an Anagram");
		
		if(isAnagramOrderN(str, str1))
			System.out.println("Anagram");
		else
			System.out.println("Not an Anagram");
	}
	

}
