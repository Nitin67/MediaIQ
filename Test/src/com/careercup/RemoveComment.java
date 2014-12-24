package com.careercup;

public class RemoveComment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "the /*this is \n comment*/ end";
		printWithoutComment(str);
	}

	private static void printWithoutComment(String str) {
		boolean lineChangeFlag = false, isComment = false;
		int i = 0;
		StringBuffer sb = new StringBuffer();
		while (i < str.length()) {
			if (!isComment) {
				if (str.charAt(i) == '/' && i + 1 < str.length()
						&& str.charAt(i + 1) == '*') {
					isComment = true;
					i = i + 2;
				} else if (!lineChangeFlag && (str.charAt(i) == '\n')) {
					sb.append('\n');
					lineChangeFlag = true;
					i = i + 2;
				} else {
					lineChangeFlag = false;
					sb.append(str.charAt(i));
					i++;
				}
			} else {
				if (str.charAt(i) == '*' && i + 1 < str.length()
						&& str.charAt(i + 1) == '/') {
					isComment = false;
					i = i + 2;
				} else {
					if (!lineChangeFlag && str.charAt(i) == '\n') {
						sb.append('\n');
						lineChangeFlag = true;
						i = i + 2;
					} else
						i++;
				}
			}
		}
		System.out.println(sb.toString());
	}

}
