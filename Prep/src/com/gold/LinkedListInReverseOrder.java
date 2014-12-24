package com.gold;



class LinkdLst
{
	int data;
	LinkdLst next;
	public LinkdLst(int data)
	{
		this.data=data;
	}
}

public class LinkedListInReverseOrder {

	public static void printLinkedInReverseOrder(LinkdLst head)
	{
		if(head==null)
			return;
		printLinkedInReverseOrder(head.next);
		System.out.println(head.data);
	}
	
	public static void main(String []args)
	{
		LinkdLst head=new LinkdLst(1);
		head.next=new LinkdLst(2);
		head.next.next=new LinkdLst(3);
		head.next.next.next=new LinkdLst(4);
		printLinkedInReverseOrder(head);
	}
}
