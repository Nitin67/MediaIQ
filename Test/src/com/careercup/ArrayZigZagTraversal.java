package com.careercup;

public class ArrayZigZagTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] stringArray = { { "A", "B", "C", "D", "E" },
				{ "F", "G", "H", "I", "J" }, { "K", "L", "M", "N", "O" },
				{ "P", "Q", "R", "S", "T" }, { "U", "V", "W", "X", "Y" } };
		printZigZag(stringArray);
	}

	private static void printZigZag(String[][] stringArray) {
		if (stringArray != null) {
			int n = stringArray[0].length;
			int counter = 0;
			for (String[] lineArray : stringArray) {
				if (counter % 2 == 0) {
					for (int i = 0; i < n; i++)
						System.out.println(lineArray[i]);
				} else {
					for (int i = n - 1; i >= 0; i--)
						System.out.println(lineArray[i]);
				}
				counter++;
			}
		}
	}

}
