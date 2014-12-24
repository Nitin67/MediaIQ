package com.careercup.dash;

public class MaximumContagiousSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 5, -3, 5, -6, -8, 3, 7, -1, 12, -9, 8 };
		int sum = highestContagiousSum(intArray, 0, intArray.length-1);
		System.out.println(sum);
	}

	private static int highestContagiousSum(int[] intArray, int i, int j) {
		if (intArray.length == 0)
			return 0;
		else if (i == j)
			return intArray[i];
		else if (i == j - 1)
			return intArray[i] + intArray[j];
		else
			return max(
					intArray[i] + intArray[j]
							+ highestContagiousSum(intArray, i + 1, j - 1),
					highestContagiousSum(intArray, i + 1, j),
					highestContagiousSum(intArray, i, j - 1));

	}

	private static int max(int i, int j, int k) {
		return Math.max(i, Math.max(j, k));
	}

}
