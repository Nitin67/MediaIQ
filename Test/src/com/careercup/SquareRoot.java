package com.careercup;

public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float root = sqrt(9, 0.000001);
		System.out.println(root);
	}

	private static float sqrt(float num, double d) {
		float x = num;
		float y = 1;
		while (x - y > d) {
			x = (x + y) / 2;
			y = num / x;
		}
		return x;
	}

}
