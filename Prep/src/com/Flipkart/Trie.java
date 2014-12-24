package com.Flipkart;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	Map<Character,Object> root = new HashMap<Character,Object>();
	public void add(String str)
	{
		Map<Character,Object> m= root;
		for (Character ch : str.toCharArray()) {
			if(m.containsKey(ch))
			{
				 m= (Map<Character, Object>) m.get(ch);
			}
			else
			{
				Map<Character,Object> newNode=new HashMap<Character, Object>();
				m.put(ch, newNode);
				m=newNode;
			}
			
		}
		m.put('.', null);
	}
	
	public boolean find(String str)
	{
		Map<Character,Object> m=root;
		for (Character ch : str.toCharArray()) {
			if(m.containsKey(ch))
			{
				m=(Map<Character, Object>) m.get(ch);
			}
			else if(!m.containsKey('.'))
			{
				return false;
			}
		}
		return true;
		
	}
	public static void main(String []args)
	{
		String s1 = "This phone. is very good.";
		String s2 = "A very very good cell phone.";
		s1=s1.replace('.', ' ');
		s2=s2.replace(',', ' ');
		String []s1Array=s1.split("(\\s+)");
		String []s2Array=s2.split("(\\s+)");
		Trie t= new Trie();
		for(String string : s1Array) {
			t.add(string);
		}
		int count=0;
		for(String string:s2Array)
		{
			if(t.find(string))
			count++;
		}
		System.out.println((int)Math.round(((double)count/(double)s2Array.length)*100.0d));
		System.out.println(s1Array.length);
		
		
	}
}
