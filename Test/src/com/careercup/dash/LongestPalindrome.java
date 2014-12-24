package com.careercup.dash;

public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String givenString = "trtrtassatrtrtjkhsdhfjsdhf";
		int longestPalindromeLength = longestPalindrome(givenString, 0,
				givenString.length() - 1);
		System.out.println(longestPalindromeLength);
	}

	private static int longestPalindrome(String givenString, int i, int j) {
		if (givenString == null)
			return 0;
		else if ((givenString.charAt(i) == givenString.charAt(j)) && i == j)
			return 1;
		else if ((givenString.charAt(i) == givenString.charAt(j)) && i == j - 1)
			return 2;
		else if (givenString.charAt(i) == givenString.charAt(j))
			return longestPalindrome(givenString, i + 1, j - 1) + 2;
		return Math.max(longestPalindrome(givenString, i + 1, j),
				longestPalindrome(givenString, i, j - 1));
	}
}
