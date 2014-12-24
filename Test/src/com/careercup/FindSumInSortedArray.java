package com.careercup;

public class FindSumInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int k = 8;
		for (int i = 0; i < array.length - 1; i++) {
			int index = binarySearch(array, i + 1, array.length - 1, k
					- array[i]);
			if (index > -1)
				System.out.println(array[i] + "," + array[index]);
		}
	}

	public static int binarySearch(int[] array, int start, int end, int k) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (array[mid] == k) {
				return mid;
			} else if (array[mid] > k) {
				return binarySearch(array, start, mid - 1, k);
			} else
				return binarySearch(array, mid + 1, end, k);
		}
		return -1;
	}

	public static int kRotatedBinarySearch(int[] array, int start, int end,
			int k) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (array[mid] == k) {
				return mid;
			} else if (array[start] <= array[end]) {
				if (array[start] <= k && k < array[mid])
					return kRotatedBinarySearch(array, start, mid - 1, k);
				else
					return kRotatedBinarySearch(array, mid + 1, end, k);
			} else {
				if (array[mid] < k && array[end] <= k)
					return kRotatedBinarySearch(array, mid + 1, end, k);
				else
					return kRotatedBinarySearch(array, start, mid - 1, k);
			}
		}
		return -1;
	}
}
