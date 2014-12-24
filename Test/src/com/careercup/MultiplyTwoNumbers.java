package com.careercup;

public class MultiplyTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray1 = { 2, 5, 1 };
		int[] intArray2 = { 2, 5 };
		multiply(intArray1, intArray2);
	}

	private static void multiply(int[] intArray1, int[] intArray2) {
		if (intArray1.length > intArray2.length) {
			int[] result = new int[intArray1.length * 2];
			for (int i = intArray2.length - 1; i >= i; i--) {
			}
		}

	}

	private static int[] multiply(int[] intArray, int n) {
		int c = 0;
		int[] result = new int[intArray.length + 1];
		for (int i = intArray.length - 1; i >= 0; i--) {
			int mul = intArray[i] * n;
			mul = mul + c;
			c = mul / 10;
			result[i + 1] = mul % 10;
		}
		result[0] = c;
		return result;
	}

	private static int[] sumArray(int[] intArray1, int[] intArray2) {
		int c = 0;
		int[] result = new int[intArray1.length + 1];
		for (int i = intArray1.length - 1, j = intArray2.length - 1; i >= 0
				|| j >= 0;) {
			int sum = 0;
			if (i >= 0 && j >= 0)
				sum = intArray1[i] + intArray2[j] + c;
			else if (i >= 0)
				sum = intArray1[i] + c;
			else
				sum = intArray2[j] + c;
			c = sum / 10;
			result[i + 1] = sum % 10;
		}
		result[0] = c;
		return result;
	}

}
