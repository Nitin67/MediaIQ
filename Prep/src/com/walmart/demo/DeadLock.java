package com.walmart.demo;

class Pen {
}

class Papper {
}

public class DeadLock {

	public static void main(String[] args) {
		final Pen pn = new Pen();
		final Papper ppr = new Papper();
		Thread t1 = new Thread() {
			public void run() {
				synchronized (pn) {
					System.out.println("Thread1 is holding pen");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {

					}
					synchronized (ppr) {
						System.out.println("Requesting for Paper");
					}
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized (ppr) {
					System.out.println("Thread2 is holding paper");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (pn) {
						System.out.println("Thread2 is requesting for Pen");
					}
				}
			}
		};
		t1.start();
		t2.start();
	}
}
