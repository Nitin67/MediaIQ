package com.careercup;

public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aaabbbbbccca";
		char[] strArray = str.toCharArray();
		int count = 1;
		char prev = '\'';
		StringBuffer strOutB = new StringBuffer();
		for (int i = 0; i <= strArray.length; i++) {
			if (i != strArray.length && strArray[i] == prev) {
				count++;
				prev = strArray[i];
			} else {
				if (prev != '\'') {
					strOutB.append(prev).append(count);
					count = 1;
				}
				if (i != strArray.length)
					prev = strArray[i];
			}
		}
		System.out.println(strOutB.toString());
	}

}
