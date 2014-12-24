package com.careercup;

public class CaseInsensitivePalindrom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Ab   B,!2@#a";
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {
		if (str == null || str.equals(""))
			return false;
		int i = 0, j = str.length() - 1;
		while (i <= j) {
			char startChar = str.charAt(i);
			char endChar = str.charAt(j);
			if (startChar == endChar) {
				i++;
				j--;
			} else if (isAlbhabet(startChar) && isAlbhabet(endChar)) {
				if (getRelativeInt(startChar) == getRelativeInt(endChar)) {
					i++;
					j--;
				} else
					return false;
			} else {
				if (!isAlbhabet(startChar))
					i++;
				if (!isAlbhabet(endChar))
					j--;

			}
		}
		return true;
	}

	private static int getRelativeInt(char character) {
		if (('a' <= character && character <= 'z'))
			return character - 'a';
		else if ('A' <= character && character <= 'Z')
			return character - 'A';
		return -1;
	}

	private static boolean isAlbhabet(char character) {
		if (('a' <= character && character <= 'z')
				|| ('A' <= character && character <= 'Z'))
			return true;
		return false;
	}

}
