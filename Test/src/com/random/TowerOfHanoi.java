package com.random;

public class TowerOfHanoi {

	public static void main(String[] args) {
		printTowerOfHanoi(3, 0, 2, 1);
	}

	private static void printTowerOfHanoi(int i, int start, int end, int buffer) {
		if (i == 1) {
			moveDisk(start, end);
		} else {
			printTowerOfHanoi(i - 1, start, buffer, end);
			moveDisk(start, end);
			printTowerOfHanoi(i - 1, buffer, end, start);
		}
	}

	private static void moveDisk(int start, int end) {
		System.out.println("Move from " + start + " to " + end);

	}

}
