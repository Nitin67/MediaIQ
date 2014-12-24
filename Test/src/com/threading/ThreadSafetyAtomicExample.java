package com.threading;

public class ThreadSafetyAtomicExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadSafetyAtomic threadSafetyAtomic = new ThreadSafetyAtomic();
		Thread t1 = new Thread(threadSafetyAtomic);
		t1.start();
		Thread t2 = new Thread(threadSafetyAtomic);
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exit Main");

	}

}
