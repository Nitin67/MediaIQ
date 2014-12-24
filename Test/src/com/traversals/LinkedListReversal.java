package com.traversals;

import com.util.LinkedListNode;

public class LinkedListReversal {
public static void main(String[] args){
	 LinkedListNode root = new LinkedListNode();
	 root.next = prepareTheList();
	 
	 root.next = reverseLinkedList(root.next);
	 print(root.next);
}

private static void print(LinkedListNode node) {
	while(node!=null){
		System.out.println(node.val);
		node =node.next;
	}
	
}

private static LinkedListNode reverseLinkedList(LinkedListNode node) {
	LinkedListNode temp = null;
	LinkedListNode previous = null;
	while(node!=null){
		temp = node.next;
		node.next = previous;
		previous = node;
		node = temp;
	}
	return previous;
}

private static LinkedListNode prepareTheList() {
	LinkedListNode lastNode = new LinkedListNode();
	LinkedListNode firstNode = null;
	for(int i=0; i<5; i++){
		LinkedListNode newNode = new LinkedListNode();
		newNode.val = i;
		lastNode.next = newNode;
		lastNode = newNode;
		if(i==0)
			firstNode = lastNode;
	}
	return firstNode;
}
}
