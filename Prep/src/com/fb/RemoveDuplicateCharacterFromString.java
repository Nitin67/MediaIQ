package com.fb;

import java.util.HashSet;

public class RemoveDuplicateCharacterFromString {

	public static void removeDuplicate(char []ch)
	{
		if(ch==null)
		return;
		int tail=1;
		for(int i=1;i<ch.length;i++)
		{
			int j=0;
			for(j=0;j<tail;j++)
			{
				if(ch[i]==ch[j])
					break;

			}
			if(j==tail)
			{
				ch[tail]=ch[i];
				tail++;
			}
		}
		while(tail<ch.length)
		ch[tail++]=0;
		
		System.out.println(ch);
	}
	
	public static void removeDuplicatePractice(char []ch)
	{
		int tail=1;
		for(int i=0;i<ch.length;i++)
		{
			int j=0;
			for(j=0;j<tail;j++)
			{
				if(ch[j]==ch[i])
					break;
			}
			if(j==tail)
			ch[tail++]=ch[i];
		}
		while(tail<ch.length)
			ch[tail++]=0;
		
		System.out.println(ch);
	}
	
	public static void removeduplicateeff(char []ch)
	{
		boolean charSet[]=new boolean[256];
		charSet[ch[0]]=true;
		int tail=1;
		for(int i=1;i<ch.length;i++)
		{
			if(!charSet[ch[i]])
			{
				ch[tail]=ch[i];
				tail++;
				charSet[ch[i]]=true;
			}
		}
		while(tail<ch.length)
			ch[tail++]=0;
		
		System.out.println(ch);
	}
	
	
	public static void removeDuplicateWithHashSet(String str)
	{
		HashSet<Character> set=new HashSet<Character>();
		for(int i=0;i<str.length();i++)
		{
			if(set.contains(str.charAt(i)));
		}
	}
	
	
	
	
	public static void main(String []args)
	{
		String str="aaaabbbba";
		removeDuplicatePractice(str.toCharArray());
		
	}
}
