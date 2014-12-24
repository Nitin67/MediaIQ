package com.careercup;
public class ArrayDiagonalPrinting {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] stringArray = { { "A", "B", "C", "D","E" },
				{ "F", "G", "H", "I","J"},
				{ "K", "L", "M", "N" ,"O"},
				{ "P", "Q", "R", "S","P"},
				{ "U", "V", "W", "X","Y"} 
				};
		printDiagonal(stringArray);
	}

	private static void printDiagonal(String[][] stringArray) {
		if (stringArray != null) {
			int m = stringArray.length;
			int n = stringArray[0].length;
			int flag;
			for (int i = 1; i <= m + n - 1; i++) {
				int startcol = Math.max(0, i - n);
				int count = Math.min(i, m - startcol);
				flag = i < n ? i : n;
				for (int j = 0; j < count; j++) {
					flag--;
					System.out.print(stringArray[startcol + j][flag]);
				}
				System.out.println();
			}
		}
	}

}
