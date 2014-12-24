package com.random;

import java.util.HashMap;
import java.util.Map;

public class TestStringParent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> map =convertFromStringToMap("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)");

	}
	private static Map<String, String> convertFromStringToMap(String str) {
		Map<String,String> map = new HashMap<String,String>();
		String[] strArray = str.split(" ");
		for(String strTuple:strArray){
			String parent = strTuple.substring(1, 2);
			String child = strTuple.substring(3,4);
			map.put(child,parent);
		}
		return null;
	}

}
