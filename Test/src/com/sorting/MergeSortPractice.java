package com.sorting;

public class MergeSortPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray = { 2, 34, 56, 2, 1, 234, 7, 89, 0, 1 };
		int[] result = mergeSort(intArray, 0, intArray.length - 1);
		for (int a : result) {
			System.out.println(a);
		}

	}

	private static int[] mergeSort(int[] intArray, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			int[] lower = mergeSort(intArray, start, mid);
			int[] upper = mergeSort(intArray, mid + 1, end);
			return merge(lower, upper);
		}
		int[] result = { intArray[start] };
		return result;
	}

	private static int[] merge(int[] lower, int[] upper) {
		int[] result = new int[lower.length + upper.length];
		int k = 0;
		int i = 0, j = 0;
		while (k < result.length) {
			if (i < lower.length && j < upper.length) {
				if (lower[i] < upper[j]) {
					result[k] = lower[i];
					i++;
				} else {
					result[k] = upper[j];
					j++;
				}
				k++;
			} else if (i < lower.length) {
				result[k] = lower[i];
				i++;
				k++;
			} else if (j < upper.length) {
				result[k] = upper[j];
				j++;
				k++;
			}
		}
		return result;
	}

}
