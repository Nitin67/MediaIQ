package com.careercup;

import java.util.Arrays;

public class SwapAnagramToMakeEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string1 = "MUG";
		String string2 = "GUM";
		swap(string1.toCharArray(), string2.toCharArray(), 0);
	}

	private static void swap(char[] charArray, char[] charArray2, int i) {
		if (i < charArray.length) {
			if (charArray[i] == charArray2[i]) {
				i++;
				swap(charArray, charArray2, i);
			} else {
				findCharAndBringToI(charArray[i], charArray2, i);
				i++;
				swap(charArray, charArray2, i);
			}
		} else
			return;
	}

	private static void findCharAndBringToI(char character, char[] charArray2,
			int k) {
		int j = k;
		while (j < charArray2.length && character != charArray2[j]) {
			j++;
		}
		for (; j > k; j--) {
			char temp = charArray2[j];
			charArray2[j] = charArray2[j - 1];
			charArray2[j - 1] = temp;
			System.out.println(Arrays.toString(charArray2));
		}

	}

}
