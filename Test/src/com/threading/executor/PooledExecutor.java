package com.threading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<100;i++){
			Worker worker = new Worker("Thread "+i);
			executorService.execute(worker);
		}
		executorService.shutdown();
		while(!executorService.isTerminated()){
			
		}
		System.out.println("Terminated all threads.");
	}

}
