package com.threading.bqueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> bqueue;

	public Consumer(BlockingQueue<Integer> bqueue) {
		this.bqueue = bqueue;
	}

	@Override
	public void run() {
		while (!bqueue.isEmpty()) {
			try {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName()
						+ " consumed " + bqueue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
