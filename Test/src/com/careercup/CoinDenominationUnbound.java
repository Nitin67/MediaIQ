package com.careercup;

public class CoinDenominationUnbound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 5 };
		findCombinations(5, coins, 0, "");

	}

	private static void findCombinations(int amount, int[] coins,
			int indexToStart, String output) {
		if (amount == 0) {
			System.out.println(output);
			return;
		}
		if (amount < 0 || indexToStart == coins.length)
			return;
		findCombinations(amount - coins[indexToStart], coins, indexToStart,
				output + "," + coins[indexToStart]);
		findCombinations(amount, coins, indexToStart + 1, output);
	}

}
