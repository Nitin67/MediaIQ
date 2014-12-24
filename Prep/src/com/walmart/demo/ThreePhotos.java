package com.walmart.demo;

import java.util.Arrays;

public class ThreePhotos {
	public static int removeCubes(String[] A, String[] B, String[] C) {
		int size = A.length;
		Integer x[] = new Integer[size];
		Arrays.fill(x, 0);
		Integer y[] = new Integer[size];
		Arrays.fill(y, 0);
		Integer z[] = new Integer[size];
		Arrays.fill(z, 0);
		for (int i = 0; i < size; i++) {
			StringBuilder str = new StringBuilder(A[i]);
			for (int j = 0; j < size; j++) {
				if (str.charAt(j) == 'N') {
					x[i] += 1;
					y[j] += 1;
				}
			}
		}
		int countx = 0;

		for (int i = 0; i < size; i++) {
			StringBuilder str = new StringBuilder(A[i]);
			for (int j = 0; j < size; j++) {
				if (str.charAt(j) == 'N') {
					x[i] += 1;
					z[j] += 1;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			StringBuilder str = new StringBuilder(A[i]);
			for (int j = 0; j < size; j++) {
				if (str.charAt(j) == 'N') {
					y[i] += 1;
					z[j] += 1;
				}
			}
		}

		return 0;

	}

	public static void main(String[] args) {

	}

}
