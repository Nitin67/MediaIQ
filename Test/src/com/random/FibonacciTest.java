package com.random;

public class FibonacciTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
		// 1 1 2 3 5 8 13 21 34 55 89
	}

	private static int fibonacci(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {

			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	}

}
