package com.careercup;

public class KanpsackProblem10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] w = new int[] { 2, 3, 4, 5 };
		int[] b = new int[] { 3, 4, 5, 6 };
		maximumNapsackValue(w, b, 5);
	}

	private static void maximumNapsackValue(int[] w, int[] b, int c) {
		if (c == 0)
			System.out.println("Invalid Knapsack");
		else {
			int[][] la = new int[w.length + 1][c + 1];
			for (int i = 1; i < la.length; i++) {
				for (int j = 1; j < la[0].length; j++) {
					if (j - w[i - 1] < 0)
						la[i][j] = la[i - 1][j];
					else
						la[i][j] = Math.max(la[i - 1][j], la[i - 1][j
								- w[i - 1]]
								+ b[i - 1]);
				}
			}
			int max = 0;
			for (int i = 0; i < la.length; i++)
				if (max < la[i][c])
					max = la[i][c];
			System.out.println("Maximum Profit " + max);

		}
	}
}
