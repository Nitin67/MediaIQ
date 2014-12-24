package com.careercup;

public class PrintAllPalindrom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "aba";
		string = modString(string);
		int[] palindromLengthArray = getPalindromLengthArray(string);
		printAllPalindroms(palindromLengthArray, string);
	}

	private static String modString(String string) {
		StringBuffer sb = new StringBuffer();
		sb.append('#');
		for (int i = 0; i < string.length(); i++)
			sb.append(string.charAt(i)).append('#');
		return sb.toString();
	}

	private static void printAllPalindroms(int[] palindromLengthArray,
			String string) {
		for (int i = 0; i < palindromLengthArray.length; i++) {
			int pos = palindromLengthArray[i];
			int k = 1;
			while (k <= pos) {
				if (k % 2 == 1)
					System.out.println(string.substring(i - k, i + k + 1)
							.replaceAll("#", ""));
				k++;
			}
		}
	}

	private static int[] getPalindromLengthArray(String string) {
		int[] array = new int[string.length()];
		for (int i = 0; i < array.length; i++) {
			array[i] = palindromLength(string, i);
		}
		return array;
	}

	private static int palindromLength(String string, int i) {
		int length = 0, k = i - 1, l = i + 1;
		while (k >= 0 && l < string.length()) {
			if (string.charAt(k) == string.charAt(l)) {
				k--;
				l++;
				length++;
			} else
				break;
		}

		return length;
	}

}
