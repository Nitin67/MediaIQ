package com.threading;

public class Semaphore {
	boolean lock = false;

	public synchronized void take() {
		lock = true;
		this.notifyAll();
	}

	public synchronized void release() {
		while (!lock) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lock = false;
	}
}
