package com.flipkart;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	Map<String, Object> trieMap = new HashMap<String, Object>();

	public boolean add(char[] string) {
		
		Map<String, Object> startMap = trieMap;
		for (char character : string) {
			if (startMap.containsKey(character)) {
				startMap = (Map<String, Object>) startMap.get(String.valueOf(
						character).toUpperCase());
			} else {
				Map<String, Object> newMap = new HashMap<String, Object>();
				startMap.put(String.valueOf(character).toUpperCase(), newMap);
				startMap = newMap;
			}
		}
		startMap.put("_", null);
		return true;

	}

	public boolean contains(char[] string) {
		Map<String, Object> startMap = trieMap;
		for (char character : string) {
			if (startMap.containsKey(String.valueOf(character).toUpperCase())) {
				startMap = (Map<String, Object>) startMap.get(String.valueOf(
						character).toUpperCase());
			} else if (!startMap.containsKey("_")) {
				return false;
			}
		}
		return true;
	}
}
