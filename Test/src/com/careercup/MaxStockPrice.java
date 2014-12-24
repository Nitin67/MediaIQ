package com.careercup;

public class MaxStockPrice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] stock = new int[] { 12, 34, 2, 12, 34, 3, 2, 12, 24, 10, 56, 23,
				42 };
		printMaxProfit(stock);
	}

	private static void printMaxProfit(int[] stock) {
		int maxProfit = Integer.MIN_VALUE;
		int minPrice = stock[0];
		for (int i = 1; i < stock.length; i++) {
			maxProfit = Math.max(maxProfit, stock[i] - minPrice);
			minPrice = Math.min(minPrice, stock[i]);
		}
		System.out.println(maxProfit);
	}

}
