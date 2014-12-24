package com.tree;

import java.util.HashMap;
import java.util.Map;


public class MinWindowInS {
	
	
	public static void main(String []args)
	{
		String str="this is a test string";
		String pat="tist";
		findMinWindowIns(str,pat);
	}

	private static void findMinWindowIns(String str, String pat) {
		
	
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		int windowsize=Integer.MAX_VALUE;
		int windowbegin=0;
		int wind=0;
		int windowend=0;
		for(int i=0;i<pat.length();i++)
		{
			if(map.containsKey(pat.charAt(i)))
			{
			Object value=map.get(pat.charAt(i));
			map.put(pat.charAt(i), (int)value+1);
			}
			else
			map.put(pat.charAt(i), 1);
		}
		Map<Character, Integer> map1=new HashMap<Character, Integer>();
		int count=0;
		for(int begin=0,end=0;end<str.length();end++)
		{
			if(map.containsKey(str.charAt(end)))
			{
				
				if(map1.containsKey(str.charAt(end)))
				{
					Object value=map1.get(str.charAt(end));
					map1.put(str.charAt(end),(int)value+1);
				}
				else
					map1.put(str.charAt(end), 1);
				if(( (int)map.get(str.charAt(end))>=(int)map1.get(str.charAt(end))))
				count++;
			}
			
			if(count==pat.length())
			{
			while(true)
				{
					if(map.containsKey(str.charAt(begin)) )
					{
						if(( (int)map.get(str.charAt(begin))>=(int)map1.get(str.charAt(begin))))
							break;
					
					else if((int)map.get(str.charAt(begin))<(int)map1.get(str.charAt(begin)))
					{
						map1.put(str.charAt(begin), (int)map1.get(str.charAt(begin))-1);
					}
					}
					begin++;
				}
				
				 wind=end-begin+1;
				if(wind<windowsize){
					windowsize=wind;
					windowbegin=begin;
					windowend=end;			
				}
				
				
			}
		}
		System.out.println(windowsize + "=" +windowbegin + ":" + windowend);
	}

}
