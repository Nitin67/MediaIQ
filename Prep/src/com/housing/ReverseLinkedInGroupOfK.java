package com.housing;


class LinkedList
{
	int data;
	LinkedList next;
	
}

public class ReverseLinkedInGroupOfK {
	
	private  LinkedList head=null;
	public void addNode(int data)
	{
		LinkedList newNode= new LinkedList();
		newNode.data=data;
		newNode.next=null;
		if(head==null)
			head=newNode;
		else
		{
			newNode.next=head;
			head=newNode;
		}
	}
	public void display(LinkedList root)
	{
		LinkedList temp=root;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

	public LinkedList reverseInGroupOfK(LinkedList head,int k)
	{
		if(head==null || k==0 || k==1)
			return head;
		LinkedList current=head;
		LinkedList prev=null;
		LinkedList nxt=null;
		int i=0;
		while(i<k && current!=null)
		{
			nxt=current.next;
			current.next=prev;
			prev=current;
			current=nxt;
			i++;
		}
		head.next=reverseInGroupOfK(current,k);
		return prev;
	}
	public static void main(String []args)
	{
		ReverseLinkedInGroupOfK linkedInGroupOfK= new ReverseLinkedInGroupOfK();
		linkedInGroupOfK.addNode(1);
		linkedInGroupOfK.addNode(2);
		linkedInGroupOfK.addNode(3);
		linkedInGroupOfK.addNode(4);
		linkedInGroupOfK.addNode(5);
		linkedInGroupOfK.addNode(6);
		linkedInGroupOfK.display(linkedInGroupOfK.head);
		
		LinkedList reverse=linkedInGroupOfK.reverseInGroupOfK(linkedInGroupOfK.head,3);
		System.out.println("Reverse");
		linkedInGroupOfK.display(reverse);
		
	}
	
	
}















