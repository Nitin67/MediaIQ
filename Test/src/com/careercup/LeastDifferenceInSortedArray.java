package com.careercup;

public class LeastDifferenceInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 5, 7, 9, 12, 222, 454 };
		int intMinDiff = intMinDiff(array, 0, array.length - 1, 100);
		System.out.println(intMinDiff);
	}

	private static int intMinDiff(int[] array, int start, int end, int k) {
		int intiMindiff = Integer.MAX_VALUE;
		if (start <= end) {
			int mid = (start + end) / 2;
			if (k == array[mid]) {
				intiMindiff = 0;
			} else if (k < array[mid]) {
				intiMindiff = intMinDiff(array, start, mid - 1, k);
			} else {
				intiMindiff = intMinDiff(array, mid + 1, end, k);
			}
		}
		return Math.min(intiMindiff,
				Math.min(Math.abs(k - array[start]), Math.abs(k - array[end])));
	}

}
