package com.careercup;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strArray = { "DOG", "CAT", "DOG", "FISH", "ROME", "TEST" };
		removeDuplicatesPrint(strArray);

	}

	private static void removeDuplicatesPrint(String[] strArray) {
		if (strArray == null || strArray.length == 0) {
			System.out.println("Word list empty");
		} else {
			Set<String> set = new HashSet<String>();
			StringBuffer sb = new StringBuffer();
			for (String str : strArray) {
				if (set.add(str))
					sb.append(str + " ");
			}
			System.out.println(sb.toString());
		}

	}

}
