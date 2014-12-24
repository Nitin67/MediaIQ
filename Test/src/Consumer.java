import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true)
			consume();
	}

	private void consume() {
		try {
			synchronized (queue) {
				while (queue.isEmpty()) {
					System.out
							.println("Consumer waiting for Producer to Produce");
					queue.wait();
				}
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		synchronized (queue) {
			System.out.println("Consumed " + queue.poll());
			queue.notifyAll();
		}
	}

}
