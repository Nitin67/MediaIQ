package com.careercup;

public class Palindromes {

	public static boolean isPalindrome(String word) {
		// Strip out non-alphanumeric characters from string
		String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
		// Check for palindrome quality recursively
		return checkPalindrome(cleanWord);
	}

	public static boolean isPalindrome2(String word) {
		// Strip out non-alphanumeric characters from string
		String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
		// Check for palindrome quality recursively
		return checkPalindrome2(cleanWord);
	}

	public static boolean checkPalindrome(String word) {
		if (word.length() < 2) {
			return true;
		}
		char first = word.charAt(0);
		char last = word.charAt(word.length() - 1);
		if (first != last) {
			return false;
		} else {
			return checkPalindrome(word.substring(1, word.length() - 1));
		}
	}

	public void replace(int first, int last) {
		if (first != last) {
			first = last;
		} else if (last != first) {
			last = first;
		}
	}

	public static boolean checkPalindrome2(String word) {
		char special = 0;
		if (word.length() < 2) {
			return true;
		}
		char first = word.charAt(0);
		char last = word.charAt(word.length() - 1);
		if (first != last) {
			return false;
		}
		if (first != last)
			return false;
		else {
			return checkPalindrome2(word.substring(1, word.length() - 1));
		}
	}
}
