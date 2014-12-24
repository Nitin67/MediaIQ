package com.careercup;

public class ReverseWordsInPlace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "The Boy Is Good";
		reverseInPlace(str);
	}

	private static void reverseInPlace(String str) {
		StringBuffer sb = new StringBuffer();
		if (str == null)
			return;
		else {
			int length = str.length();
			for (int i = 0; i < length - 1; i++) {
				if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'
						|| str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
					int j = i;
					while (j < str.length()
							&& (str.charAt(j) >= 'a' && str.charAt(j) <= 'z' || str
									.charAt(j) >= 'A' && str.charAt(j) <= 'Z')) {
						j++;
					}
					sb.append(reverse(str.substring(i, j)));
					i = j-1;
				} else {
					sb.append(Character.toString(str.charAt(i)));
				}
			}
		}
		System.out.println(sb.toString());
	}

	private static String reverse(String str) {
		char[] charArray = str.toCharArray();
		int i = 0, j = charArray.length - 1;
		while (i < j) {
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			i++;
			j--;
		}
		return String.copyValueOf(charArray);
	}

}
