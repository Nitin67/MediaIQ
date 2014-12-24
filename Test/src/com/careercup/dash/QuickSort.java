package com.careercup.dash;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arary = { 1, 2, 3, 123, 24, 125, 0, 1232, -1 };
		quickSort(arary, 0, arary.length - 1);
		for (Integer in : arary)
			System.out.println(in);
	}

	private static void quickSort(Integer[] arary, int start, int end) {
		if (start <= end) {
			int pivotPosition = partition(arary, start, end);
			quickSort(arary, start, pivotPosition - 1);
			quickSort(arary, pivotPosition + 1, end);
		}
	}

	private static int partition(Integer[] arary, int start, int end) {
		int pivotPosition = start;
		Integer pivot = arary[pivotPosition];
		start++;
		while (start <= end) {
			while ((start <= end) && (arary[start] < pivot))
				start++;
			while ((start <= end) && (arary[end] >= pivot))
				end--;
			if (start > end)
				swap(arary, pivotPosition, end);
			else
				swap(arary, start, end);
		}
		return end;
	}

	private static void swap(Integer[] arary, int i, int j) {
		Integer temp = arary[i];
		arary[i] = arary[j];
		arary[j] = temp;
	}

}
