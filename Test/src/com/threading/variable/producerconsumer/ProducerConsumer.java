package com.threading.variable.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = 5;
		Thread producer = new Thread(new Producer(queue,size),"Producer");
		Thread consumer = new Thread(new Consumer(queue, size),"Consumer");
		producer.start();
		consumer.start();
	}

}
