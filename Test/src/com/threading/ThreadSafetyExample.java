package com.threading;

public class ThreadSafetyExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadSafetyThread thread = new ThreadSafetyThread();
		Thread thread1 = new Thread(thread, "Thread 1");
		thread1.start();
		Thread thread2 = new Thread(thread, "Thread 2");
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Exiting Main thread");
	}

}
