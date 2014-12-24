package com.aconex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This is solution to 1800 code challenge. This takes input from Command line
 * for a file name with fully qualified path Or Input of number from STDIN. For
 * each line (number) it would process it output the sequence on console. At the
 * end of input type QUIT.
 * 
 * user specific dictionary. Dictionary has to be of format:
 * 
 * <Number>:Char1,Char2,Char3...,CharN; e.g
 * 
 * 2=A,B,C:3=D,E,F:4=G,H,I:5=J,K,L:6=M,N,O:7=P,Q,R,S:8=T,U,V:9=W,X,Y,Z
 * 
 * and argument to start program would be
 * 
 * -Ddictionary="2=A,B,C:3=D,E,F:4=G,H,I:5=J,K,L:6=M,N,O:7=P,Q,R,S:8=T,U,V:9=W,X,Y,
 * 
 */
public class Aconex1800Code {

	private static final String DICTIONARY_PROPERTY = "dictionary";
	private static DictionaryUtil dictionaryUtil = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize dictionary.
		initializeDictionary();
		// Read input.
		String inputFileName = null;
		BufferedReader in = null;
		if (args != null && args.length > 0) {
			inputFileName = args[0];
			try {
				// Read form file.
				in = new BufferedReader(new InputStreamReader(
						new FileInputStream(inputFileName)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			// Read from file or STDIN.
			in = new BufferedReader(new InputStreamReader(System.in));
		}
		String lineStr = null;
		try {
			lineStr = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (lineStr != null && !"QUIT".equals(lineStr)) {
			generateCombination(lineStr);
			try {
				lineStr = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param String
	 *            number number is the String of phone number which has to be
	 *            processed.
	 */
	private static void generateCombination(String number) {
		char[] characterArray = number.toCharArray();
		List<String[]> stringList = new ArrayList<String[]>();
		boolean prev = false;
		if (characterArray != null && characterArray.length > 0) {
			for (char c : characterArray) {
				if (c < 58 && c > 47) {
					String[] strArray = dictionaryUtil.getArray(Character
							.getNumericValue(c));
					if (strArray == null) {
						if (prev)
							return;
						strArray = new String[] { String.valueOf(Character
								.getNumericValue(c)) };
						prev = true;
					} else {
						prev = false;
					}
					stringList.add(strArray);
				} else {
					stringList.add(new String[] { "-" });
					prev = false;
				}
			}
		}
		combination(stringList, 0, "");

	}

	/**
	 * 
	 * @param stringList
	 *            List of String arrays from the dictionary.
	 * @param i
	 *            is the parameter that specifies the depth of number to be
	 *            processed. If this is equal to length print the number.
	 * @param str
	 *            String formed so far from recursion.
	 * 
	 *            This method recursively forms the string pattern.
	 * 
	 */
	private static void combination(List<String[]> stringList, int i, String str) {
		if (i < stringList.size()) {
			String[] strArray = stringList.get(i);
			int j = 0;
			while (strArray != null && strArray.length > 0
					&& j < strArray.length) {
				combination(stringList, i + 1, str + strArray[j]);
				j++;
			}
		} else if (i == stringList.size()) {
			System.out.println(str);
		}

	}

	/**
	 * This method initializes the user specific dictionary.
	 */
	private static void initializeDictionary() {
		// Get property dictionary from System properties.
		String dictionaryString = System.getProperty(DICTIONARY_PROPERTY);
		// Initialize dictionary to be used.
		if ("".equals(dictionaryString)) {
			dictionaryUtil = new DictionaryUtil(null);
		} else {
			dictionaryUtil = new DictionaryUtil(dictionaryString);
		}
	}

	/**
	 * 
	 * @return object of dictionary util.
	 */
	public static DictionaryUtil getDictionaryUtil() {
		return dictionaryUtil;
	}

	/**
	 * 
	 * @param dictionaryUtil
	 *            Set dictionary Util.
	 */
	public static void setDictionaryUtil(DictionaryUtil dictionaryUtil) {
		Aconex1800Code.dictionaryUtil = dictionaryUtil;
	}

}
