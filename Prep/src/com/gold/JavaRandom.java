package com.gold;

import java.util.Random;

public class JavaRandom {
	long seed;
	
	JavaRandom (long seed) {
		this.seed = (seed ^ 0x5DEECE66DL) & ((1L << 48) - 1);
	}
	
	protected int next (int bits) {
		this.seed = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
		return (int)(seed >>> (48 - bits));
	}

	public int nextInt() {
		return next(32);
	}
	
	public int nextInt(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n must be positive");

		if ((n & -n) == n)  // i.e., n is a power of 2
			return (int)((n * (long)next(31)) >> 31);

		int bits, val;
		do {
			bits = next(31);
			val = bits % n;
		} while (bits - val + (n-1) < 0);
		return val;
	}
	
	public static void main (String[] args) {
		int seed = 100;
		int limit = 100;
		Random r = new Random (seed);
		JavaRandom jr = new JavaRandom (seed);
		
//		System.out.println (r.nextInt());
//		System.out.println (jr.nextInt());
//		
//		System.out.println (r.nextInt(limit));
//		System.out.println (jr.nextInt(limit));
		long l=2l;
		System.out.println(0x5DEECE66DL);
		
		
		
	}
}