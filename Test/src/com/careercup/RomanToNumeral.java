package com.careercup;

public class RomanToNumeral {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "XXXIX";
		System.out.println(romanToNumeral(str));
	}

	private static int romanToNumeral(String str) {
		int previous = 0;
		int sum = 0;
		int current = 1001;
		char[] stringChar = str.toCharArray();
		for (int i = 0; i < stringChar.length; i++) {
			if (stringChar[i] == 'I')
				current = 1;
			else if (stringChar[i] == 'V')
				current = 5;
			else if (stringChar[i] == 'X')
				current = 10;
			else if (stringChar[i] == 'L')
				current = 50;
			else if (stringChar[i] == 'C')
				current = 100;
			else if (stringChar[i] == 'D')
				current = 500;
			else if (stringChar[i] == 'M')
				current = 1000;
			if (current <= previous)
				sum = sum + current;
			else
				sum = sum - previous - previous + current;
			previous = current;
		}
		return sum;
	}

}
