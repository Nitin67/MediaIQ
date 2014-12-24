package com.careercup;

public class InPlaceArrayOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 0, 3 };
		int size = a.length;
		for (int i = 0; i < size; i++) {
			a[i] = a[i] + (a[a[i] % size] % size) * size;
		}
		for (int i = 0; i < size; i++) {
			a[i] = a[i] / size;
		}
		for (int i : a)
			System.out.println(i);
	}

}
