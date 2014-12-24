package com.careercup;

import java.util.HashSet;
import java.util.Set;

public class MalfunctioningKeyResolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String expected = "12344574";
		String actual = "12357";
		Integer noOfFaultyKeys = 1;
		if (isSame(expected, actual, noOfFaultyKeys))
			System.out.println("Password Matched");
		else
			System.out.println("Password Didn't Match");

	}

	private static boolean isSame(String expected, String actual,
			Integer noOfFaultyKeys) {
		Set<Character> cahrSet = new HashSet<Character>();
		int i = 0, j = 0;
		while (i < expected.length() && j < actual.length()) {
			if (expected.charAt(i) == actual.charAt(j)) {
				i++;
				j++;
			} else {
				cahrSet.add(expected.charAt(i));
				i++;
			}

		}
		return cahrSet.size() > noOfFaultyKeys ? false : true;
	}

}
