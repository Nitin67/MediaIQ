package com.linkedlist;

import java.util.LinkedList;

public class ReverseAlternateNodeAppendAtEnd {
	
	public static void main(String []args)
	{
		LinkedList<Integer>  linkedList= new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		
		for(int i=0;i<linkedList.size();i++)
		{
			System.out.println(linkedList.get(i));
		}
		int size=linkedList.size()/2+1;
		for(int i=1;i<size;i=i+2)
		{
			linkedList.add(linkedList.size()-i+1, linkedList.get(i));
			linkedList.remove(i);
			i--;
		}
		for(int i=0;i<linkedList.size();i++)
		{
			System.out.println( "value="+linkedList.get(i));
		}	
		
	}

}
