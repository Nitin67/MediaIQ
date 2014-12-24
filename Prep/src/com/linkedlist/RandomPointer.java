package com.linkedlist;


class llist{
	int data;
	llist next;
	llist random;
}

public class RandomPointer {

	llist root=null;
	llist cloneRoot=null;
	public void cloning()
	{
		llist temp=root;
		while(temp!=null)
		{
			llist linked= new llist();
			linked.data=temp.data;		
			linked.next=  temp.next;
			temp.next=linked;
			temp=temp.next.next;
		}
		temp=root;
		while(temp!=null)
		{
			if(temp.random!=null)
				temp.next.random=temp.random.next;
			
			temp=temp.next.next;
		}
		temp=root;
		while(temp.next!=null)
		{
			if(cloneRoot==null)
			{
				cloneRoot=temp.next;
			}
			llist temp1=null;
			temp1=temp.next;
			temp.next=temp.next.next;
			
			if(temp.next==null)
			{
			temp1.next=null;
			}
			else{
			temp1.next=temp.next.next;
			temp=temp.next;
			}
		}
	}
	public void add(int data)
	{
		llist l= new llist();
		l.data=data;
		l.next=null;
		l.random=null;
		if(root==null)
			root=l;
		else
		{
			l.next=root;
			root=l;
		}
	}
	public void randomize()
	{
		llist temp=root;
		temp.random=temp.next.next;
	    temp.next.random=temp;
	    temp.next.next.random=temp.next;
	}
	public void display()
	{
		llist temp=root;
		while(temp!=null)
		{
		System.out.println(temp.data + "   "+temp.random.data);
		temp=temp.next;
		}
		temp=cloneRoot;
		while(temp!=null)
		{
		System.out.println(temp.data + "   "+temp.random.data);
		temp=temp.next;
		}
	}

	public static void main(String []args)
	{
		RandomPointer randomPointer= new RandomPointer();
		randomPointer.add(10);
		randomPointer.add(20);
		randomPointer.add(30);
		randomPointer.randomize();
		randomPointer.cloning();
		randomPointer.display();
		
		
	}

}