package com.threading.variable.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable {

	private Queue<Integer> queue;
	private int size;

	public Producer(Queue<Integer> queue, int size) {
		this.queue = queue;
		this.size = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			produce(i);
		}
	}

	public void produce(int i) {
		while (queue.size() == size) {
			synchronized (queue) {
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " is waiting for elements to be consumed");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

		synchronized (queue) {
			queue.offer(i);
			System.out.println("Thread " + Thread.currentThread().getName()
					+ " Produced " + i);
			queue.notifyAll();
		}
	}
}
