package com.linkedlist;


import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class UnionOfLinkedList {
	
	
	public static LinkedList<Integer> unionOfLinkedList(LinkedList<Integer> list1,LinkedList<Integer> list2)
	{
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;
		LinkedList<Integer> list3=new  LinkedList<Integer>();
		Set<Integer> set=new HashSet<Integer>();
		Iterator<Integer> it=list1.iterator();
		while(it.hasNext())
		{
			int data=it.next();
			if(!set.contains(data))
			set.add(data);
		}
		it=list2.iterator();
		while(it.hasNext())
		{
			int data=it.next();
			if(!set.contains(data))
			set.add(data);
		}
		
		it=set.iterator();
		while(it.hasNext())
		{
			list3.add(it.next());
		}
		return list3;

	}
	
	
	public static LinkedList<Integer> unionOfLinkedListWithOutExtraSpace(LinkedList<Integer> list1,LinkedList<Integer> list2)
	{
		if(list1==null)
			return list1;
		if(list2==null)
			return list2;
		Collections.sort(list1);
		Collections.sort(list2);
		
		LinkedList<Integer> list3=new LinkedList<Integer>();
		int i=0,j=0,k=0;
		while(i<list1.size() && j<list2.size())
		{
			int data1=list1.get(i);
			int data2=list2.get(j);
			if(data1<data2)
				{
				if(list3.size()>=1 &&list3.get(k-1)==data1)
				{
					i++;
					continue;
				}
				list3.add(data1);
				i++;
				k++;
				}
			else{
				if(list3.size()>=1 &&list3.get(k-1)==data2)
				{
					j++;
					continue;
				}
				list3.add(data2);
				j++;
				k++;
			}
					
		}
		while(i<list1.size())
		{
			int data1=list1.get(i);
			if(list3.size()>=1 &&list3.get(k-1)==data1)
			{
				i++;
				continue;
			}
			else{
			list3.add(data1);
			i++;
			k++;}
		}
		while(j<list2.size())
		{
			int data1=list2.get(j);
			if(list3.size()>=1 && list3.get(k-1)==data1)
			{
				j++;
				continue;
			}
			else{
			list3.add(data1);
			j++;
			k++;}
		}
		
		
		return list3;
	}
	
	
	
	public static void main(String []args)
	{
		LinkedList<Integer> list1=new LinkedList<Integer>();
		LinkedList<Integer> list2=new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list2.add(5);
		list2.add(1);
		list2.add(6);
		list2.add(7);
		list2.add(2);
		list2.add(3);
		list2.add(7);
		//LinkedList<Integer> list3= unionOfLinkedList(list1, list2);
		LinkedList<Integer> list3=unionOfLinkedListWithOutExtraSpace(list1, list2);
		Iterator<Integer> it=list3.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

}
