package com.string;

import java.util.*;

public class PermutationExample {
	static Set<String> strSet = new HashSet<String>();
	public static void main(String args[]) throws Exception {
		String[] chars = {"a","b","c"};
		showPattern("", chars);
		Iterator<String> itr = strSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}

	public static void showPattern(String st, String[] chars) {
		strSet.add(st);
		if (chars.length < 1);
			//System.out.println(st + chars);
		else
			for (int i = 0; i < chars.length; i++) {
				try {
					String[] newString = concatAll(Arrays.copyOfRange(chars, 0, i-1<0?0:i),Arrays.copyOfRange(chars, i+1>chars.length?chars.length:i+1, chars.length));
					
					showPattern(st + chars[i], newString);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		  int totalLength = first.length;
		  for (T[] array : rest) {
		    totalLength += array.length;
		  }
		  T[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (T[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}
}