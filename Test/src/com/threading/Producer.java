package com.threading;

import java.util.Queue;

public class Producer implements Runnable {

	private Queue<Integer> queue;
	private Semaphore semaphore;
	private Integer count = 0;

	public Producer(Queue<Integer> queue, Semaphore semaphore, Integer length) {
		this.queue = queue;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		while (true) {
			produce();
		}
	}

	private void produce() {
		semaphore.take();
		queue.offer(++count);
		System.out.println("Produced " + queue.poll());
		semaphore.release();

	}

}
