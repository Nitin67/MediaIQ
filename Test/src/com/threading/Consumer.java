package com.threading;

import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Integer> queue;
	private Semaphore semaphore;
	public Consumer(Queue<Integer> queue,Semaphore semaphore) {
		this.queue = queue;
		this.semaphore = semaphore;
	}
	@Override
	public void run() {
		while(true)
			consume();
	}
	private void consume() {
		semaphore.take();
		System.out.println("Consumed "+queue.poll());
		semaphore.release();
	}

}
