package com.fb;

public final class RingBuffer<T> {
	
	private final T[] elements;
	private int offset=0;
	private int unconsumedElements=0;
	
	public RingBuffer(int size)
	{
		if(size<=0)
			throw new IllegalArgumentException("RingBuffer capacity must be positive");
		
		elements=(T[])new Object[size];
	}

	public synchronized void add(T element) throws InterruptedException{
		
		while(unconsumedElements==elements.length)
			wait();
		
		elements[offset]=element;
		offset=(offset+1)%elements.length;
		unconsumedElements++;
		notifyAll();
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
	public synchronized T remove() throws InterruptedException{
		T result=peek();
		unconsumedElements--;
		notifyAll();
		return result;
	}

	public synchronized T peek() throws InterruptedException{
		while(unconsumedElements==0)
			wait();
		
		return elements[(offset+(getCapacity()-getSize()))%getCapacity()];
	}
}
