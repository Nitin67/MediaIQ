package com.hackerRank;

public class CircularQueue<T> implements CircularQueueInterface {

	public static final int capacity= 5;
	int f=0;
	int r=0;
	public Object [] queue;
	public CircularQueue()
	{
		queue=new Object[capacity];
	}
	public CircularQueue(int capacity) {
		queue=new Object[capacity];
	}
	@Override
	public int size() {
		if(r-f>=0)
			return r-f;
		else 
		{
			return capacity+(r-f);
		}
	}

	@Override
	public boolean isFull() {
		if(r-f==-1 || r-f==capacity-1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmpty() {
		if(r==f)
			return true;
		else
			return false;
	}

	@Override
	public void enqueue(Object obj) {
		if(isFull())
			System.out.println("Queue is full so can't add");
		else{
			queue[r]=obj;
			r=(r+1)%capacity;
		}
	}

	@Override
	public Object dequeue() {
		Object item=null;
		if(isEmpty())
		{
			System.out.println("Queue is empty so can't delete");
		}
		else
		{
			item=queue[f];
			queue[f]=null;
			f=(f+1)%capacity;
		}
		return item;
	}
	public static void main(String []args)
	{
		CircularQueue circularQueue= new CircularQueue();
		circularQueue.enqueue("A");
		circularQueue.enqueue("B");
		circularQueue.enqueue("C");
		circularQueue.enqueue("D");
		System.out.println(circularQueue.size());
		System.out.println(circularQueue.isEmpty());
		System.out.println(circularQueue.isFull());
		System.out.println(circularQueue.dequeue());
		circularQueue.enqueue("E");
		
	}
	

}
