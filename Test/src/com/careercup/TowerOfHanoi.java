package com.careercup;

public class TowerOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		moveTower(3, 0, 2, 1);
	}

	public static void moveTower(int n, int start, int end, int buffer) {
		if (n == 1) {
			moveDisk(start, end);
		} else {
			moveTower(n - 1, start, buffer, end);
			moveDisk(start, end);
			moveTower(n - 1, buffer, end, start);
		}
	}

	private static void moveDisk(int start, int end) {
		System.out.println("move one disk from " + start + " to " + end);

	}
}
