package com.housing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Trie {

	public  Map<Character,Object> root=new HashMap<Character, Object>();
	public void addToTrie(String word)
	{
		Map<Character, Object> map=root;
		for (Character c : word.toCharArray()) {
			
			if(map.containsKey(c))
			{
				map=(Map<Character, Object>) map.get(c);
			}
			else
			{
				Map<Character,Object> newNode= new HashMap<Character, Object>();
				map.put(c, newNode);
				map=newNode;
			}
			
		}
		map.put('.', null);
	}
	
	public boolean findInTrie(String word)
	{
		Map<Character, Object> map=root;
		for (Character c : word.toCharArray()) {
			if(map.containsKey(c))
			{
				map=(Map<Character, Object>) map.get(c);
			}
			else if(!map.containsKey('.'))
			{
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		String str1=in.nextLine();
		str1=str1.toLowerCase();
		
		String str2=in.nextLine();
		str2=str2.toLowerCase();
		str1=str1.replace(',', ' ');
		str1=str1.replace('.', ' ');
		str2=str2.replace(',', ' ');
		str2=str2.replace('.', ' ');
		String []str1Array=str1.split("\\s+");
		String []str2Array=str2.split("\\s+");
		Trie trie=new Trie();
		for (String string : str2Array) {
			trie.addToTrie(string);	
		}
		int count=0;
		for (String string : str1Array) {
			if(trie.findInTrie(string))
				count++;
		}
		System.out.println(count);
	}
}
