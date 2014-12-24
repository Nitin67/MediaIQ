package com.careercup;

import java.util.HashMap;
import java.util.Map;

public class FindPatterInText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "ILOVEPEPSODENTTOOTHPASTE";
		String pattern = "TOOTH";
		int i = findPattern(text, pattern);
		if (i != -1)
			System.out.println("Match found at index " + i);
		else
			System.out.println("Match not found");
	}

	private static int findPattern(String text, String pattern) {
		Map<Character, Integer> badMatchMap = createBadMatchMap(pattern);
		int start = pattern.length() - 1;
		Character chPatter = pattern.charAt(start);
		while (start < text.length()) {
			Character chText = text.charAt(start);
			boolean flag = false;
			if (chPatter == chText)
				flag = match(pattern, text, start);
			if (!flag) {
				if (badMatchMap.containsKey(chText))
					start = start + badMatchMap.get(chText);
				else
					start = start + badMatchMap.get('*');
			} else
				return start - pattern.length();

		}
		return -1;
	}

	private static boolean match(String pattern, String text, int start) {
		int i = pattern.length() - 1;
		boolean flag = true;
		while (i >= 0 && start >= 0) {
			if (pattern.charAt(i) == text.charAt(start)) {
				i--;
				start--;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private static Map<Character, Integer> createBadMatchMap(String pattern) {
		Map<Character, Integer> badMatchMap = new HashMap<Character, Integer>();
		int i = 0, length = pattern.length();
		while (i < length) {
			Character ch = pattern.charAt(i);
			if (i == length - 1) {
				if (!badMatchMap.containsKey(ch))
					badMatchMap.put(ch, length);
			} else {
				badMatchMap.put(ch, length - i - 1);
			}
			i++;
		}
		badMatchMap.put('*', length);
		return badMatchMap;
	}

}
