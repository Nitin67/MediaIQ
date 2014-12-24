package com.careercup;

public class StringReversalByWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "This is Integral Interview Coding Question";
		System.out.println(reverseWordsAndSentence(str));
		System.out.println(reverseSentence(str));
		System.out.println("0,4 "+str.substring(0,4));
		System.out.println("5,7 "+str.substring(5,str.length()));
	}

	private static String reverseSentence(String str) {
		int length = str.length() - 1;
		StringBuffer sb = new StringBuffer();
		int end = length + 1;
		while (length >= 0) {
			if (str.charAt(length) == ' ') {
				if (end != -1) {
					sb.append(str.substring(length + 1, end));
					end = -1;
				}
				sb.append(" ");
				length--;
			} else {
				if (end == -1)
					end = length + 1;
				length--;
			}
		}
		if (end != -1) {
			sb.append(str.substring(length + 1, end));
		}
		return sb.toString();
	}

	private static String reverseWordsAndSentence(String str) {
		int length = str.length() - 1;
		StringBuffer sb = new StringBuffer();
		int end = length + 1;
		while (length >= 0) {
			if (str.charAt(length) == ' ') {
				if (end != -1) {
					sb.append(reverse(str.substring(length + 1, end)));
					end = -1;
				}
				sb.append(" ");
				length--;
			} else {
				if (end == -1)
					end = length + 1;
				length--;
			}
		}
		if (end != -1) {
			sb.append(reverse(str.substring(length + 1, end)));
		}
		return sb.toString();
	}

	private static String reverse(String substring) {
		char[] charSeq = substring.toCharArray();
		int end = charSeq.length - 1;
		int start = 0;
		while (start < end) {
			char temp = charSeq[end];
			charSeq[end] = charSeq[start];
			charSeq[start] = temp;
			end--;
			start++;
		}
		return String.valueOf(charSeq);
	}

}
