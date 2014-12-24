package com.fb;

public class RingBufferImpl<T> {

	private T[] elements;
	int offset=0;
	int unconsumedElements;
	
	public  RingBufferImpl(int size)
	{
		elements=(T[])new Object[size];
	}
	public synchronized int getSize()
	{
		return unconsumedElements;
	}
	public synchronized int getCapacity()
	{
		return elements.length;
	}
	public synchronized boolean isEmpty()
	{
		return getSize()==0;
	}
	public synchronized void add  (T element) throws InterruptedException
	{
		if(unconsumedElements==getCapacity())
			wait();
		
		elements[offset]=element;
		offset=(offset+1)%getCapacity();
		notifyAll();
			
	}
	
	public synchronized T peek() throws InterruptedException
	{
		if(getSize()==0)
			wait();
		
		return elements[(offset+(getCapacity()-getSize()))%getCapacity()];
		
	}
	
	public synchronized T remove() throws InterruptedException{
		T result=peek();
		unconsumedElements--;
		notifyAll();
		return result;
	}
}
