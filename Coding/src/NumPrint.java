
public class NumPrint implements Runnable {
	private Integer o = 1;
//	private  int i = 1;

	public void run() {
		try {
			System.out.println();
			while (o< 100) {
			synchronized (o) {
				if (Thread.currentThread().getName().equals("Even")) {
					if (this.o % 2 == 0) {
						o.wait();
					}
					System.out.println(Thread.currentThread().getName() + o);
					o++;
					o.notify();
				} else {
					if (this.o % 2 != 0) {
						o.wait();
					}
					System.out.println(Thread.currentThread().getName() + o);
					o++;
					o.notify();
				}
			}
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
	}

//	private void printEven() throws InterruptedException {
//		while (i < 100) {
//			synchronized (o) {
//				while (this.i % 2 == 0) {
//					o.wait();
//				}
//				System.out.println(Thread.currentThread().getName() + i);
//				i++;
//				o.notify();
//			}
//		}
//	}

//	private void printOdd() throws InterruptedException {
//		while (i < 100) {
//			synchronized (o) {
//				while (this.i % 2 != 0) {
//					o.wait();
//				}
//				System.out.println(Thread.currentThread().getName() + i);
//				i++;
//				o.notify();
//			}
//		}
//	}
}
