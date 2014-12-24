import java.util.Queue;

public class Producer implements Runnable {

	private Queue<Integer> queue;
	private Integer MAX_LENGTH;

	public Producer(Queue<Integer> queue, Integer length) {
		this.queue = queue;
		this.MAX_LENGTH = length;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			produce(i);
			i++;
		}
	}

	private void produce(Integer i) {
		try {
			synchronized (queue) {
				while (queue.size() == MAX_LENGTH - 1) {
					System.out.println("Producer Waiting for producing");
					queue.wait();
				}
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		synchronized (queue) {
			queue.offer(i);
			System.out.println("Produced : " + i);
			queue.notifyAll();
		}
	}

}
