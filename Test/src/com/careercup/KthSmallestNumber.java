package com.careercup;

public class KthSmallestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = { 13, 32, 28, 17, 2, 0, 14, 34, 35, -2 };
		int k = 6;
		int result = kthSmallestNumber(k, array, 0, array.length - 1);
		System.out.println(result);
	}

	public static int kthSmallestNumber(int k, Integer[] array, int start,
			int end) {
		int pivot = partition(array, start, end);
		if (pivot == (k - 1)) {
			return array[k - 1];
		}
		if ((k - 1) < pivot) {
			return kthSmallestNumber(k, array, start, pivot - 1);
		} else {
			return kthSmallestNumber(k, array, pivot + 1, end);
		}
	}
	
	public static int partition(Integer[] array, int start, int end) {
		int pivot = array[start];
		int pivotPosition = start;
		start++;
		while (start <= end) {
			while ((start <= end) && (array[start] < pivot)) {
				start++;
			}
			while ((end >= start) && (array[end] >= pivot)) {
				end--;
			}
			if (start > end) {
				swap(array, pivotPosition, end);
			} else {
				swap(array, start, end);
			}
		}
		return end;
	}

	public static void swap(Integer[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
