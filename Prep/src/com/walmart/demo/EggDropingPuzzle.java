package com.walmart.demo;

import javax.swing.text.html.MinimalHTMLWriter;

public class EggDropingPuzzle {

	public static int minTrail(int eggs, int floor) {

		if (floor == 1 || floor == 0)
			return floor;
		if (eggs == 1)
			return floor;
		int min = Integer.MAX_VALUE, res;

		for (int i = 1; i <= floor; i++) {
			res = min(minTrail(eggs - 1, i - 1), minTrail(eggs, floor - i));
			if (res < min)
				min = res;
		}
		return min + 1;

	}

	public static int min(int a, int b) {
		return (a > b) ? a : b;

	}

	public static void main(String[] args) {

		System.out.println(minTrail(2, 30));
	}

}
