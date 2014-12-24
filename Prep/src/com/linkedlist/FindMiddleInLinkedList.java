package com.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class FindMiddleInLinkedList {

	public static void main(String []args)
	{
		List<String> list=new LinkedList<String>();
		for(int i=0;i<100;i++)
		{
			list.add(String.valueOf(i));
		}
		System.out.println(list.get(list.size()/2));
	}
}
