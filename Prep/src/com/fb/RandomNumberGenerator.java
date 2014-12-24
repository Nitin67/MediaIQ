package com.fb;

import java.util.Random;

public class RandomNumberGenerator {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandom(100));
			Thread.sleep(1);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandom());
			Thread.sleep(1);
		}

	}
	
	static int getRandom(int range){
		Random rand = new Random(System.currentTimeMillis());
		return rand.nextInt(range);
	}
	
	static int getRandom(){
		Random rand = new Random(System.currentTimeMillis());
		return rand.nextInt();
	}

}
