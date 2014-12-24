package com.careercup;

import java.util.Arrays;

public class AddBinaryRepresentedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addBinary("110", "11011");
	}

	private static void addBinary(String string1, String string2) {
		int i = string1.length() - 1, j = string2.length() - 1;
		int c = 0;
		int[] sum = new int[Math.max(i + 3, j + 3)];
		int k = sum.length - 1;
		while (i >= 0 || j >= 0 || k >= 0) {
			if (i >= 0 && j >= 0) {
				sum[k] = string1.charAt(i) - 48 + string2.charAt(j) - 48 + c;
				c = sum[k] / 2;
				sum[k] = sum[k] % 2;
				k--;
				i--;
				j--;
			} else if (i >= 0) {
				sum[k] = string1.charAt(i) - 48 + c;
				c = sum[k] / 2;
				sum[k] = sum[k] % 2;
				k--;
				i--;
			} else if (j >= 0) {
				sum[k] = string2.charAt(j) - 48 + c;
				c = sum[k] / 2;
				sum[k] = sum[k] % 2;
				k--;
				j--;
			} else {
				sum[k] = c % 2;
				c = c / 2;
				k--;
			}
		}
		System.out.println(Arrays.toString(sum));
	}

}
