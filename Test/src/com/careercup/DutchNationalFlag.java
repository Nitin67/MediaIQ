package com.careercup;

import java.util.Arrays;

public class DutchNationalFlag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 2, 3, 2, 1, 2, 3, 3, 2, 1, 2 };
		dutchNationalFlag(array, 2, 2);
		System.out.println(Arrays.toString(array));
	}

	private static void dutchNationalFlag(int[] array, int high, int low) {
		int startIndex = 0;
		int endIndex = array.length - 1;
		for (int i = 0; i < endIndex;) {
			if (array[i] < low) {
				int temp = array[i];
				array[i] = array[startIndex];
				array[startIndex] = temp;
				startIndex++;
				i++;
			} else if (array[i] > high) {
				int temp = array[i];
				array[i] = array[endIndex];
				array[endIndex] = temp;
				endIndex--;
			} else
				i++;
		}
	}

}
