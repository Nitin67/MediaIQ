package com.random;

public class Sort0And1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 1, 1, 1, 1, 0, 0, 1 };
		int start = 0, end = a.length-1;
		while (start < end) {
			if (a[end] == 1) {
				--end;
				continue;
			}
			if (a[start] == 0) {
				++start;
				continue;
			}
			int t = a[start];
			a[start] = a[end];
			a[end] = t;
		}
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}

}
