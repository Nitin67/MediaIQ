package com.careercup;

public class PrintBalancedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printBalancedBraces("", 5, 5);

	}

	private static void printBalancedBraces(String string, int i, int j) {
		if (j == 0 && i == j)
			System.out.println(string);
		if (i >= 0 && j >= 0) {
			if (i >= 0) {
				printBalancedBraces(string + "(", i - 1, j);
			}
			if (j > i) {
				printBalancedBraces(string + ")", i, j - 1);
			}

		}
		return;
	}

}
