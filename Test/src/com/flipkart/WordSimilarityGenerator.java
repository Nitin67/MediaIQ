package com.flipkart;

public class WordSimilarityGenerator {
	private static Trie trie = new Trie();

	public static void main(String[] args) {
		String s1 = "This phone. is very good.";
		String s2 = "A very very good cell phone.";
		s1 = s1.replace('.', ' ');
		s2 = s2.replace(',',' ');
		String[] trieStringArray = null;
		trieStringArray = s1.split("(\\s+)");
		compare(trieStringArray, s2.split("(\\s+)"));
	}

	public static void compare(String[] trieStringArray,
			String[] compareStringArray) {
		for (String trieString : trieStringArray) {
			trie.add(trieString.toCharArray());
		}
		int i = 0;
		for (String compareString : compareStringArray) {
			if (trie.contains(compareString.toCharArray()))
				i++;
		}
		int percentage = (int) (Math.round((double) i/ ((double) compareStringArray.length) * 100.0d));
		System.out.println(percentage);
	}
}
