package com.threading.variable.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable {

	private Queue<Integer> queue;
	private int size;

	public Consumer(Queue<Integer> queue, int size) {
		this.queue = queue;
		this.size = size;
	}

	@Override
	public void run() {
		while(true){
			consume();
		}
	}

	private void consume() {
		while (queue.isEmpty()) {
			synchronized (queue) {
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " no elements in queue to consume.");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (queue) {
			Integer in = queue.poll();
			System.out.println("Consumed " + in);
			queue.notifyAll();
		}

	}
}
