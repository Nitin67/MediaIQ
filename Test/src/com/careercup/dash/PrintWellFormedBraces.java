package com.careercup.dash;

public class PrintWellFormedBraces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int bracesCount = 3;
		printWellFormedBraces("",bracesCount,0,0);
	}

	private static void printWellFormedBraces(String brace, int bracesCount,
			int open, int close) {
		if(open==bracesCount&&close==bracesCount)
			System.out.println(brace);
		if(open<bracesCount)
			printWellFormedBraces(brace+"{", bracesCount, open+1, close);
		if(open>close)
			printWellFormedBraces(brace+"}", bracesCount, open, close+1);
	}

}
