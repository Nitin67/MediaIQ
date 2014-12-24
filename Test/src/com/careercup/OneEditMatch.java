package com.careercup;

public class OneEditMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (isOneEditMatch("CAT", "BAT"))
			System.out.println("One Edit Possible");
		;
	}

	private static boolean isOneEditMatch(String string, String string2) {
		if (string == null && string2 == null)
			return false;
		if (string == null)
			if (string2 != null && string2.length() == 1)
				return true;
			else
				return false;
		if (string2 == null)
			if (string != null && string.length() == 1)
				return true;
			else
				return false;
		if (Math.max(string.length(), string2.length())
				- Math.min(string.length(), string2.length()) > 1)
			return false;
		else {
			int diff = 0;
			for (int i = 0, j = 0; i < string.length() && j < string2.length(); i++, j++) {
				if (string.charAt(i) != string2.charAt(j)) {
					diff++;
				}
			}
			if (diff > 1)
				return false;
			else
				return true;

		}
	}

}
