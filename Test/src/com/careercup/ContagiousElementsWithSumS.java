package com.careercup;

public class ContagiousElementsWithSumS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray = { 1, 7, 6, 3, 5, 8, 9 };
		int sum = 16;
		findContagiousElementsWithSum(intArray, sum, 0, intArray.length - 1);
	}

	private static boolean findContagiousElementsWithSum(int[] intArray,
			int sum, int start, int end) {
		if (intArray == null)
			return false;
		if (start > end)
			return false;
		else {
			int temp = 0;
			for (int i = start; i <= end; i++) {
				temp = temp + intArray[i];
			}
			if (temp == sum) {
				System.out.println("{" + start + "," + end + "}");
				return true;
			}
			boolean result = findContagiousElementsWithSum(intArray, sum,
					start + 1, end);
			if (result)
				return result;
			else
				result = findContagiousElementsWithSum(intArray, sum, start,
						end - 1);
			return result;

		}

	}

}
