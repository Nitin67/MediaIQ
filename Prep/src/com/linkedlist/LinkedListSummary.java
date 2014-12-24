package com.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class lst
{
	int data;
	lst next;
}

public class LinkedListSummary {

	lst root=null;
	lst end=null;
	
	public void addNode(int data)
	{
		lst ls=new lst();
		ls.data=data;
		ls.next=null;
		if(root==null){
			root=ls;
			end=ls;
		}
		else
		{	ls.next=root;
			root=ls;
			end.next=root;
		}
	}

	public static void main(String []args)
	{
		List<Integer> integers=new LinkedList<Integer>();
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		for(int i=1;i<=n;i++)
		{
			integers.add(i);
		}
		int k=scanner.nextInt();
		int i=0;
		ListIterator<Integer> iterator=integers.listIterator();
		int kl=k%n;
		while(i<n-1)
		{
			int size=integers.size();
			if(kl>size)
				kl=kl%size;
			int l=0;
			if(l<kl && !iterator.hasNext())
			{
				iterator=integers.listIterator();
			}
			while(l<kl && iterator.hasNext())
			{
				l++;
				iterator.next();
				if(l<kl && !iterator.hasNext())
				{
					iterator=integers.listIterator();
				}
			}
			iterator.remove();
			i++;
		}	
		System.out.println(integers.get(0));
		integers.remove(0);
		

		LinkedListSummary linkedListSummary=new LinkedListSummary();
		for( i=n;i>=1;i--)
		{
			linkedListSummary.addNode(i);
		}
		
		i=0;
		k=k%n;
		lst temp1=linkedListSummary.root;
		lst temp=null;
		
		while(i<n-1)
		{
			temp=temp1;
			for(int j=0;j<k-1;j++)
				temp=temp.next;
			temp.next=temp.next.next;
			
			temp1=temp1.next;
			i++;
		}
		System.out.println(temp.data);
	//	System.out.println(integers.get(0));
	}
}
