package com.threading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	Semaphore semaphore = new Semaphore(1);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SemaphoreExample semaphoreExample = new SemaphoreExample();
		new Thread() {
			@Override
			public void run() {
				semaphoreExample.doSomething();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				semaphoreExample.doSomething();
			}
		}.start();
	}

	public void doSomething() {
		try {
			semaphore.acquire();
			System.out.println(" Running" + Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println("Releasing " + Thread.currentThread().getName());
		}
	}
}
