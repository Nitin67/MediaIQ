package com.walmart.demo;

import java.util.Arrays;

public class OlympicCandles {
	public static int numberOfNights(int candles[]) {
		Arrays.sort(candles);
		int count = 0;
		while (true) {

			if (count > candles.length - 1)
				break;
			int g = 1;
			for (int i = 0; i < count + 1; i++) {
				if (candles[candles.length - 1 - i] == 0) {
					g = 0;
					break;
				}
				candles[candles.length - 1 - i] -= 1;

			}
			if (g == 0)
				break;
			else {
				int s = count;
				// while (s < candles.length - 1
				// && candles[candles.length - s - 1] < candles[candles.length
				// - s - 2]) {
				// int temp = candles[candles.length - count - 1];
				// candles[candles.length - count - 1] = candles[candles.length
				// - count - 2];
				// candles[candles.length - count - 1] = temp;
				// s++;
				//
				// }
				Arrays.sort(candles);

				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		int candles[] = { 1, 3, 4 };
		System.out.println(numberOfNights(candles));
	}

}
