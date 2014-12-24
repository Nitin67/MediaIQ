import java.util.LinkedList;
import java.util.Queue;


public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Thread producer = new Thread(new Producer(queue, 5));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}

}
