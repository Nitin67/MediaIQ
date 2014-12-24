package com.careercup;

public class MergeTwoSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 3, 21, 23, 24, 67,-1, -1, -1, -1, -1, -1};
		int[] b = { 1, 4, 24, 56, 68, 90 };
		merge(a, b);
		for (int n : a) {
			System.out.println(n);
		}

	}

	private static void merge(int[] a, int[] b) {
		int n = a.length, m = b.length;
		int i = 5 - 1, j = m - 1, k = n - 1;
		while (i >= 0 || j >= 0) {
			if (j >= 0 && i>=0 && a[i] > b[j]) {
				a[k] = a[i];
				i--;
				k--;
			} else if (j >=0 && i>=0 && a[i] < b[j]) {
				a[k] = b[j];
				k--;
				j--;
			} else {
				if (j >= 0) {
					a[k] = b[j];
					k--;
					j--;
				}
				if (i >= 0) {
					a[k] = a[i];
					i--;
					k--;
				}
			}
		}

	}
}
