package com.patternMatching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NaiveSolution {
	
	public static void search(String text,String pattern)
	{
		if(text==null || pattern==null || text.length()<pattern.length())
			return;
		for(int i=0;i<text.length()-pattern.length();i++)
		{
			int j=0;
			for( j=0;j<pattern.length();j++)
			{
				if(text.charAt(i+j)!=pattern.charAt(j))
				break;
			}
			if(j==pattern.length())
				System.out.println("Pattern matched at "+ i);
		}
		
	}
	public static void main(String []args) throws IOException
	{
		InputStreamReader inputStreamReader= new InputStreamReader(System.in);
		BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
		System.out.println("Enter the Text");
		String text=bufferedReader.readLine();
		System.out.println("Enter the Pattern ");
		String pattern = bufferedReader.readLine();
		search(text, pattern);
		
	}

}
