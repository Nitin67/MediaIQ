package com.careercup;

public class PrintWellFormedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 5;
		if (args != null && args.length != 0) {
			count = Integer.valueOf(args[0]);
		}
		print("", 0, 0, 3);

	}

	private static void print(String string, int open, int close, int count) {
		if (open == count && close == count) {
			System.out.println(string + "||||");
		}
		if (open < count)
			print(string + "{", open + 1, close, count);
		if (close < open)
			print(string + "}", open, close + 1, count);
		return;
	}

}
