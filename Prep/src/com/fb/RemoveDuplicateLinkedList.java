package com.fb;

import java.util.HashSet;
import java.util.Hashtable;


class LinkedListNode{
 int data;
 LinkedListNode next;

public LinkedListNode(int data) {
	this.data=data;
	this.next=null;
	// TODO Auto-generated constructor stub
}


void appendToTail(int d)
{
	LinkedListNode end=new LinkedListNode(d);
	LinkedListNode node=this;
	while(node.next!=null)
		node=node.next;
	node.next=end;
	
}

}

public class RemoveDuplicateLinkedList {

	public static void rempoveDuplicateFromLinkedList(LinkedListNode linkedListhead)
	{
		LinkedListNode head=linkedListhead;
		if(head==null)
			return;
		
		HashSet<Integer> set=new HashSet<Integer>();
		LinkedListNode prev=null;
		while(head.next!=null)
		{
			int size=set.size();
			set.add(head.data);
			if(size==set.size())
			{
				if(head.next!=null )
					prev.next=head.next;
			}
			prev=head;
			head=head.next;
		}
	}
	
	public static void removeDuplicateFromLinkedList(LinkedListNode linkedListNode)
	{
		if(linkedListNode==null || linkedListNode.next==null) return ;
		LinkedListNode prev=linkedListNode;
		LinkedListNode current=linkedListNode.next;
		while(current!=null)
		{
			LinkedListNode runner=linkedListNode;
			while(runner!=current)
			{
				if(runner.data==current.data)
				{
					prev.next=current.next;
					current=current.next;
				}
				runner=runner.next;
			}
			prev=current;
			current=current.next;
		}
	}
	
	public static void removeDuplicateFromLinkedListOrderN(LinkedListNode linkedListNode)
	{
		if(linkedListNode==null || linkedListNode.next==null) return;
		int check=0;
		LinkedListNode node=linkedListNode.next;
		LinkedListNode prev=linkedListNode;
		check|=prev.data;
		while(node!=null)
		{
			if((check&(1<<node.data))!=0)
			{
				prev.next=node.next;
			}
			else
				check|=(1<<node.data);
			
			prev=node;
			node=node.next;
		}
	}
	
	
	public static void printValueOfLinkedList(LinkedListNode head)
	{
		
		while(head!=null)
		{
			System.out.print(head.data + "-->");
			head=head.next;
		}
	}
	
	
	
	public static void main(String []args)
	{
		LinkedListNode linkedListNode=new LinkedListNode(3);
		linkedListNode.next=new LinkedListNode(2);
		linkedListNode.next.next=new LinkedListNode(4);
		linkedListNode.next.next.next=new LinkedListNode(4);
		linkedListNode.next.next.next.next=new LinkedListNode(5);
		linkedListNode.next.next.next.next.next=new LinkedListNode(6);
		//rempoveDuplicateFromLinkedList(linkedListNode);
		//removeDuplicateFromLinkedList(linkedListNode);
		removeDuplicateFromLinkedListOrderN(linkedListNode);
		printValueOfLinkedList(linkedListNode);
		
	}
}
