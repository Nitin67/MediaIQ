package com.fb;

import java.util.HashMap;

public class LRUCache<T> {

	HashMap<Integer, T> map =new HashMap<Integer, T>();
	DoublyLinkedList head;
	DoublyLinkedList end;
	int capacity;
	int len=0;
	public LRUCache(int capacity) {
		this.capacity=capacity;
		// TODO Auto-generated constructor stub
	}
	public  int getSize() 
	{
		return len;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public boolean isEmpty()
	{
		return getSize()==0;
	}
	
}

class DoublyLinkedList<T>{
	int key;
	T value;
	DoublyLinkedList prev;
	DoublyLinkedList next;
	public DoublyLinkedList(int key,T value) {
		this.key=key;
		this.value=value;
		
	}
}