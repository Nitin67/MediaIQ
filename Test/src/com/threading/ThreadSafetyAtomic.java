package com.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyAtomic implements Runnable {

	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			processCommand(i);
	}

	private void processCommand(int i) {
		try {
			Thread.sleep(i * 100);
			System.out.println(count.intValue());
			count.getAndIncrement();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
