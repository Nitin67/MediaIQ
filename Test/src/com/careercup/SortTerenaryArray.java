package com.careercup;

public class SortTerenaryArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2 };
		int i = 0, j = a.length - 1;
		while (j > i) {
			if (a[j] < 1) {
				while (a[i] < 1&&j > i) {
					i++;
				}
				if(j == i)
					break;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
				continue;
			} else if (a[i] >0) {
				while (a[j] > 0&&j > i)
					j--;
				if(j == i)
					break;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
				continue;
			}
			i++;j--;
		}
		j = a.length - 1;
		while (j > i) {
			if (a[j] < 2) {
				while (a[i] < 2&&j > i) {
					i++;
				}
				if(j == i)
					break;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
				continue;
			} else if (a[i] >1) {
				while (a[j] > 1&&j > i)
					j--;
				if(j == i)
					break;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
				continue;
			}
			i++;j--;
		}
		for (int t : a) {
			System.out.println(t);
		}
	}
}
