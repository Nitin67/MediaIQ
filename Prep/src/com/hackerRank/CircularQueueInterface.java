package com.hackerRank;

public interface CircularQueueInterface {

	public int size();
	public boolean isFull();
	public boolean isEmpty();
	public void enqueue(Object obj);
	public Object dequeue();
}
