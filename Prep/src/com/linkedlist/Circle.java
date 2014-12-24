package com.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Circle {

	public static void main(String []args)
	{
		LinkedList<Integer> list =new LinkedList<Integer>();
		LinkedList<Integer> list1 =new LinkedList<Integer>();
		Scanner scanner=new  Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int j=1;
		for(int i=0;i<=n;i++)
		{
			list.add(i);
			list1.add(i);
		}
		int m=j;
		while(j<n)
		{
			int size=list.size();
			
			if(m>=size)
				m=m-size;
			int kl=k+m;
			if(kl>size-1)
			{
				kl=kl%(size-1);
			}
			list.remove(kl);
			j++;
			m++;
		}
		list.remove(0);
		System.out.println(list.peek());
		j=1;
		int kl=1;
		while(j<n)
		{
			int size=list1.size();
			 kl=k+kl;
			if(kl>size-1)
			{
				kl=kl%(size-1);
			}
			list1.remove(kl);
			j++;
		}
		list1.remove(0);
		System.out.println(list1.peek());
		
	}
}
