package com.careercup;

import java.util.Arrays;

public class BringAllZerosToEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 4, 0, 12, 0, 122, 0, 21, 0, 0, 23, 3,
				21, 0 };
		bringAllKToEnd(array, 0);
		System.out.println(Arrays.toString(array));
	}

	private static void bringAllKToEnd(int[] array, int k) {
		int lastNonKIndex = getLastNonKIndex(array, array.length - 1, k);
		for (int i = 0; i < lastNonKIndex; i++) {
			if (array[i] == k) {
				swap(array, i, lastNonKIndex);
				lastNonKIndex = getLastNonKIndex(array, lastNonKIndex, k);
			}
		}
	}

	private static void swap(int[] array, int i, int lastNonKIndex) {
		int temp = array[i];
		array[i] = array[lastNonKIndex];
		array[lastNonKIndex] = temp;
	}

	private static int getLastNonKIndex(int[] array, int length, int k) {
		if (array != null && length > 0) {
			while (array[length] == k && length >= 0)
				length--;
			return length;
		}
		return 0;
	}

}
