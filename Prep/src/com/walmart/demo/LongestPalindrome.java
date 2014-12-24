package com.walmart.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestPalindrome {

	public String longestPalindromefun(String s) {
		int maxLength = 0, start = 0;
		if (s == null)
			return null;
		if (s.length() == 1)
			return s;
		Boolean[][] table = new Boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			Arrays.fill(table[i], false);
		}
		for (int i = 0; i < s.length(); i++) {
			table[i][i] = true;
			if (i < (s.length() - 1)) {
				if (s.charAt(i) == s.charAt(i + 1))
					table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}
		for (int k = 3; k <= s.length(); k++) {
			for (int i = 0; i < s.length() - k + 1; i++) {
				int j = k + i - 1;
				if (table[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {

					table[i][j] = true;
					if (k > maxLength) {
						maxLength = k;
						start = i;
					}

				}
			}

		}
		String str = s.substring(start, start + maxLength);
		return str;

	}

	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(inputStreamReader);
		System.out.println("Enter the string to find longest palindrome :");
		String str = bufReader.readLine();
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		String s = longestPalindrome.longestPalindromefun(str);
		System.out.println(s);
	}
}
