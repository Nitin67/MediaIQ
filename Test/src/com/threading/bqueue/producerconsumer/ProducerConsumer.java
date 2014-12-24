package com.threading.bqueue.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Integer> bqueue = new ArrayBlockingQueue<Integer>(10);
		int maxSize = 10;
		Thread producer = new Thread(new Producer(bqueue, maxSize), "Producer");
		Thread consumer = new Thread(new Consumer(bqueue), "Consumer");
		producer.start();
		consumer.start();
	}

}
