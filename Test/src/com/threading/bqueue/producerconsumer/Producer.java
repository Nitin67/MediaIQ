package com.threading.bqueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer> bqueue;
	int maxSize;

	public Producer(BlockingQueue<Integer> bqueue, int size) {
		this.bqueue = bqueue;
		this.maxSize = size;
	}

	@Override
	public void run() {
		int i = 0;
		while (bqueue.size() < maxSize) {
			try {
				Thread.sleep(10);
				bqueue.put(i);
				System.out.println(Thread.currentThread().getName()
						+ " produced " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}
