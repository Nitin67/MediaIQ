package com.threading;

import java.util.LinkedList;
import java.util.Queue;

public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore();
		Queue<Integer> queue = new LinkedList<Integer>();
		Thread producer = new Thread(new Producer(queue, semaphore, 5));
		Thread consumer = new Thread(new Consumer(queue, semaphore));
		producer.start();
		consumer.start();
	}

}
