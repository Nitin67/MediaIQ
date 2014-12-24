package com.threading;

public class ThreadSafetyThread implements Runnable {
	int count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			process(i);
			count++;
		}
	}

	private void process(int i) {
		if(true)
		try {
			Thread.sleep(i * 1000);
			System.out.println(Thread.currentThread().getName() + " " + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
