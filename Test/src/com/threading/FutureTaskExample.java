package com.threading;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FutureTask<String> ft1 = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return Thread.currentThread().getName()+": "+ (new Date()).getTime();
			}
		});
		ft1.run();
		while(!ft1.isDone()){
		}
		try {
			System.out.println(ft1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
