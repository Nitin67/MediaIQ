package com.careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceOfPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, List<String>> dictionary = new HashMap<String, List<String>>();
		List<String> list0 = new ArrayList<String>();
		list0 = Arrays.asList(new String[] { "A", "B", "C" });
		dictionary.put("0", list0);
		List<String> list1 = new ArrayList<String>();
		list1 = Arrays.asList(new String[] { "D", "E", "F" });
		dictionary.put("1", list1);
		List<String> list2 = new ArrayList<String>();
		list2 = Arrays.asList(new String[] { "G", "H", "I" });
		dictionary.put("2", list2);
		List<String> list3 = new ArrayList<String>();
		list3 = Arrays.asList(new String[] { "J", "K", "L" });
		dictionary.put("3", list3);
		List<String> list4 = new ArrayList<String>();
		list4 = Arrays.asList(new String[] { "M", "N", "O" });
		dictionary.put("4", list4);
		List<String> list5 = new ArrayList<String>();
		list5 = Arrays.asList(new String[] { "P", "Q", "R" });
		dictionary.put("5", list5);
		List<String> list6 = new ArrayList<String>();
		list6 = Arrays.asList(new String[] { "S", "T", "U" });
		dictionary.put("6", list6);
		List<String> list7 = new ArrayList<String>();
		list7 = Arrays.asList(new String[] { "V", "W", "X" });
		dictionary.put("7", list7);
		List<String> list8 = new ArrayList<String>();
		list8 = Arrays.asList(new String[] { "Y", "Z", "@" });
		dictionary.put("8", list8);
		List<String> list9 = new ArrayList<String>();
		list9 = Arrays.asList(new String[] { "+", "#", "$" });
		dictionary.put("9", list9);
		printSequences("03345", 0, dictionary, "");
	}

	private static void printSequences(String string, int i,
			Map<String, List<String>> dictionary, String output) {

		if (string.length() == i) {
			System.out.println(output);
			return;
		}
		Integer number = Integer.valueOf(Character.toString(string.charAt(i)));
		List<String> list = dictionary.get(number.toString());
		for (String str : list) {
			printSequences(string, i + 1, dictionary, output + str);
		}

	}
}
