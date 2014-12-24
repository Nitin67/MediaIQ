package com.careercup;

public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(match("abbc", "a.*bbc"));
	}

	private static boolean match(String string, String pattern) {
		if (pattern.length() == 0)
			return string.length() == 0;
		if (pattern.length() == 1 || pattern.charAt(1) != '*') {
			if (string.length() < 1
					|| (pattern.charAt(0) != '.' && pattern.charAt(0) != string
							.charAt(0)))
				return false;
			return match(string.substring(1), pattern.substring(1));
		} else {
			int i = -1;
			int length = string.length();
			while (i < length
					&& (i < 0 || pattern.charAt(0) == '.' || pattern.charAt(0) == string
							.charAt(i))) {
				if (match(string.substring(i + 1), pattern.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}

}
