package com.boomerang;

import java.util.Scanner;


public class Queueimplementation {

	private int capacity;
	int arr[];
	int size=0;
	int head=-1;
	int tail=0;
	public Queueimplementation(int capacity)
	{
		this.capacity=capacity;
		this.arr=new int[capacity];
	}
	public void pop(){
		if(head>=tail){
			//System.out.println("Popped Element is :" + arr[tail]);
			tail++;
			size--;
		}else{
			System.out.println("Underflow");
		}
	}
	public void push(int data)
	{

		if(head>=capacity-1)
		{
			int temp[]=new int[capacity];
			for(int i=tail;i<=head;i++)
				temp[i]=arr[i];
			this.capacity= 2 * this.capacity;
			this.arr=new int[capacity];
			for(int i=tail;i<=head;i++)
				arr[i]=temp[i];
		}
		head++;
		size++;
		arr[head]=data;
		//System.out.println("Element pushed is : " + arr[head]);
	}
	public void display()
	{
		for(int i=tail;i<=head;i++)
			System.out.print(arr[i]);
	}
	
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		Queueimplementation queueimplementation= new Queueimplementation(Integer.parseInt(s));
		StringBuilder str=new StringBuilder();
		s = in.nextLine();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				int k;
				if(str.toString()!="" && str!=null)
				{ k=Integer.parseInt(str.toString());
				queueimplementation.push(k);
				str=new StringBuilder();
				}
			}
			else
				str.append(s.charAt(i));
			if(i==s.length()-1)
			{

				int k;
				if(str.toString()!="" && str!=null)
				{ k=Integer.parseInt(str.toString());
				queueimplementation.push(k);
				str=new StringBuilder();
				}
			
			}
				 
		}
		s = in.nextLine();
		if(Integer.parseInt(s)==0)
			queueimplementation.pop();
		else{s = in.nextLine();
			queueimplementation.push(Integer.parseInt(s));
		}
		queueimplementation.display();
	}
}
