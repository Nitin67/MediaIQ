package com.adobe;

class Node
{
	int data;
	Node next;
}

public class ReversalOfLinkedList {
	
	public static Node addNode(int data,Node root)
	{
		Node ls=new Node();
		ls.data=data;
		ls.next=null;
		if(root==null){
			root=ls;
		}
		else
		{	ls.next=root;
			root=ls;
		}
		return root;
	}
	
	
	public static Node reverseLinkedList(Node head)
	{
		Node current=head;
		Node prev=null;
		Node nextNode=null;
		while(current!=null)
		{
			nextNode=current.next;
			current.next=prev;
			prev=current;
			current=nextNode;
		}
		return prev;
	}
	
	public static void main(String []args)
	{
		Node root=null;
		root=addNode(1,root);
		root=addNode(2,root);
		root=addNode(3,root);
		root=reverseLinkedList(root);
	}
}
