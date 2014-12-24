package com.sorting;

public class MergeSort {
	private static int[] intArray = { 2, 34, 56, 2, 1, 234, 7, 89, 0, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = intArray.length;
		int k = length;
		int[] arrayOut = mergeSort(intArray, 0, k - 1);
		for (int a : arrayOut) {
			System.out.println(a);
		}

	}

	private static int[] mergeSort(int[] intArray2, int start, int end) {
		if (start < end) {
			int length = end - start + 1;
			int k = length / 2;
			int[] a = mergeSort(intArray2, start, k - 1);
			int[] b = mergeSort(intArray2, k, end);
			return merge(a, b);
		}
		int[] x = { intArray2[start] };
		return x;
	}

	private static int[] merge(int[] a, int[] b) {

		int lengthA = a.length;
		int lengthB = b.length;
		int[] c = new int[lengthA + lengthB];
		int k = 0;
		int i = 0, j = 0;
		while (k < c.length) {
			if (i < lengthA && j < lengthB) {
				if (a[i] < b[j]) {
					c[k] = a[i];
					i++;
				} else {
					c[k] = b[j];
					j++;
				}
			}else if(i<lengthA){
				c[k] = a[i];
				i++;
			}else if(j<lengthB){
				c[k] = a[j];
				j++;
			}
			k++;
		}

		return c;
	}
}
