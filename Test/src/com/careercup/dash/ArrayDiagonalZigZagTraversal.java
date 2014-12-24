package com.careercup.dash;

public class ArrayDiagonalZigZagTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] stringArray = { { "A", "B", "C", "D", "E" },
				{ "F", "G", "H", "I", "J" }, { "K", "L", "M", "N", "O" },
				{ "P", "Q", "R", "S", "T" }, { "U", "V", "W", "X", "Y" } };
		printDiagonal(stringArray);
	}

	private static void printDiagonal(String[][] stringArray) {
		if (stringArray != null) {
			int m = stringArray.length;
			int n = stringArray[0].length;
			for (int i = 1; i <= m + n - 1; i++) {
				int start_col = Math.max(0, i - m);
				int count = Math.min(i, n - start_col);
				int flag = i < m ? i : m;
				for (int j = 0; j < count; j++) {
					flag--;
					System.out.print(stringArray[flag][start_col + j]);
				}
			}
		}
	}

}
