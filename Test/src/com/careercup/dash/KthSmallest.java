package com.careercup.dash;

public class KthSmallest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 12, 30, 125, 5, 221, 42312, 121, 22,
				123 };
		int index = kthSmallest(array, 0, array.length - 1, 5);
		System.out.println(array[index]);

	}

	private static int kthSmallest(int[] array, int start, int end, int k) {
		int pivot = getPivotPosition(array, start, end);
		if (pivot == k-1)
			return pivot;
		else if (k - 1 < pivot)
			return kthSmallest(array, start, pivot - 1, k);
		else
			return kthSmallest(array, pivot + 1, end, k);
	}

	private static int getPivotPosition(int[] array, int start, int end) {
		int pivot = start;
		start++;
		while (start <= end) {
			while (start <= end && array[start] <= array[pivot])
				start++;
			while (start <= end && array[end] > array[pivot])
				end--;
			if (start <= end) {
				swap(array, start, end);
			} else {
				swap(array, pivot, end);
			}
		}
		return end;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
