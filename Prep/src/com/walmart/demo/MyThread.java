package com.walmart.demo;

class Thread4 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			System.out.println("r1 ");
			Thread.sleep(100);

		} catch (InterruptedException ie) {

		}
		System.out.println("r2");
	}
}

class sync {
	public void display(String msg) {
		System.out.println("[" + msg);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
}

class Thread5 extends Thread {

	private sync s;
	private String msg;

	Thread5(sync s, String msg) {
		this.s = s;
		this.msg = msg;
		start();
	}

	public void run() {
		synchronized (s) {
			s.display(msg);
		}

	}
}

public class MyThread {

	public static void main(String[] args) throws InterruptedException {
		// Thread4 thread = new Thread4();
		// Thread4 thread1 = new Thread4();
		// thread.start();
		// thread1.start();
		// System.out.println(thread.isAlive());
		// System.out.println(thread1.isAlive());
		//
		// // Join()
		// Thread4 thread2 = new Thread4();
		// Thread thread3 = new Thread4();
		// thread2.start();
		//
		// try {
		// thread2.join(10);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// thread3.start();
		sync s = new sync();

		Thread5 thr = new Thread5(s, "Welcome");
		Thread5 thr1 = new Thread5(s, "new");
		Thread5 thr2 = new Thread5(s, "programmer");

	}
}
