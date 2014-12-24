package com.careercup.dash;

public class SwapAndMakeEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "MUGING";
		String str2 = "IGNGUM";
		if (str1.length() != str2.length()) {
			System.out
					.println("Two strings are of different lengths so swapping isn't possible.");
			return;
		}
		swapAndMakeEqual(str1, str2, 0);
	}

	private static void swapAndMakeEqual(String str1, String str2, int i) {
		if (i < str2.length()) {
			if (str1.charAt(i) == str2.charAt(i)) {
				i++;
				swapAndMakeEqual(str1, str2, i);
			} else {
				str2 = findAndReplace(str2.toCharArray(), str1.charAt(i), i);
				i++;
				swapAndMakeEqual(str1, str2, i);
			}
		}
	}

	private static String findAndReplace(char[] str2, char charAtStr2, int i) {
		if (i < str2.length) {
			int j = i;
			j++;
			while (j < str2.length && str2[j] != charAtStr2) {
				j++;
			}
			while (j > i) {
				char temp = str2[j];
				str2[j] = str2[j - 1];
				str2[j - 1] = temp;
				j--;
			}
			String str = String.valueOf(str2);
			System.out.println(str);
			return str;
		}
		return null;
	}

}
