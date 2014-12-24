package com.Flipkart;

import java.util.HashMap;
import java.util.Map;

public class TrieTesting {

	Map<Character,Object> root= new HashMap<Character,Object>();
	public void add(String str)
	{
		Map<Character,Object> m=root;
		for (Character ch : str.toCharArray()) {
			if(m.containsKey(ch))
			{
				m=(Map<Character, Object>) m.get(ch);
			}
			else
			{
				Map<Character,Object> newNode= new HashMap<Character,Object>();
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
		TrieTesting trie= new TrieTesting();
		
		int i=0;
		for (String string : s1Array) {
		trie.add(string);	
		}
		for (String string : s2Array) {
			if(trie.find(string))
				i++;
		}
		System.out.println((int)Math.round(((double)i/(double)s2Array.length)*100.0d));
		
	}
	
}
