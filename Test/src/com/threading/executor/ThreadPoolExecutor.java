package com.threading.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(5);
		for(int i=0;i<100;i++){
			Worker worker = new Worker("Thread "+i);
			try {
				blockingQueue.put(worker);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(5, 5, 10, TimeUnit.MILLISECONDS, blockingQueue);
		threadPoolExecutor.prestartCoreThread();
		threadPoolExecutor.shutdown();
		//while(!threadPoolExecutor.isTerminated()){}
		//System.out.println("Thread Pool is terminated.");
	}

}
