package com.threading.executor;

public class Worker implements Runnable {

	String name;

	public Worker(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Running Thread: " + name);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
