package com.careercup;

public class KRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		int val = 25;
		int index = binarySearch(array, val);
		if (index != -1)
			System.out.println("Number found at " + (index + 1));
		else
			System.out.println("Number not found");

		int index2 = kRotatedBinarySearch(array, 0, array.length-1, val);
		System.out.println(index2);

	}

	public static int binarySearch(int array[], int val) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == val)
				return mid;
			if (array[start] <= array[mid]) { // Increasing
				if (array[start] <= val && val < array[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {
				if (array[mid] < val && val <= array[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
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
				if (array[mid] < k && array[end] >= k)
					return kRotatedBinarySearch(array, mid + 1, end, k);
				else
					return kRotatedBinarySearch(array, start, mid - 1, k);
			}
		}
		return -1;
	}

}
