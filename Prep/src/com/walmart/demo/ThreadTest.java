package com.walmart.demo;

class Thread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Concurrent thread started running");
	}

}

class Thread2 extends Thread {
	public void run() {
		System.out.println("Thread extended from Thread");
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		t.getName();
		t.setName("mainThread");
		System.out.println("Name of th thread is " + t);
		System.out.println("Norm Priority :" + t.getPriority());

		Thread1 t1 = new Thread1();
		Thread t2 = new Thread(t1,"try");
		System.out.println(t2.getName());
		t2.start();
		t2.yield();

		// t2.start(); // IllegalThreadStateException as thread is already in
		// runnable state and we try to start again

		// MyThread thread = new MyThread();
		// Thread t3 = new Thread(thread);
		// t3.start();
		Thread2 t4 = new Thread2();
		t4.start();
		Thread2 t5 = new Thread2(); // thread won't allocated a new call stack
		t5.run();

	}
}
