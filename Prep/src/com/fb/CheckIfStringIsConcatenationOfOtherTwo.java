package com.fb;

import java.util.HashSet;

public class CheckIfStringIsConcatenationOfOtherTwo {

	public static boolean checkConcatenation(String str,String []dic)
	{
		HashSet<String> set=new HashSet<String>();
		for(String s:dic)
		set.add(s);
		
		boolean []table=new boolean[str.length()+1];
		table[0]=true;
		for(int i=0;i<str.length();i++)
		{
			for(int j=0;j<i;j++)
			{
				if(set.contains(str.substring(j, i+1)))
				{
					if(table[j])table[i+1]=true;
				}
			}
		}
		return table[str.length()];
				
	}
	
	public static void main(String []args)
	{
		String []dictionary={"world","hello","super","hell"};
		System.out.println(checkConcatenation("hellword", dictionary));
		
	}
	
}
