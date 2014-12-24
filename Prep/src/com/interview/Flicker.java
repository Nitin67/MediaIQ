package com.interview;
import java.util.HashSet;
import java.util.Set;
public class Flicker {

	public boolean IsProper(String str)
	{
		char ch[]=str.toCharArray();
		int j=1;
		while(j<=3)
		{
			Set<String> set=new HashSet<String>();
		for(int i=0;i<str.length() && j+i<str.length();i++)
		{
			int size=set.size();
			set.add(String.valueOf(ch[i])+String.valueOf(ch[i+j]));
			if(set.size()==size)
				return false;
		}
			j++;
		}
		return true;
	}
	
	
	public static void main(String []args)
	{
		Flicker flicker=new Flicker();
		System.out.println(flicker.IsProper("FLGL"));
	}
}
