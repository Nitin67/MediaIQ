package com.careercup;

public class LargestRepeatedCharacter {

	public static void main(String[] args) {
		String str = "ashkajfsfsjaaaasjdaskfsadnnnnnnaslkdjaskdjnasndsssddssdsdddd";
		char[] charArray = str.toCharArray();
		int previoublock = 0, block = 1, blockIndex = 0;
		char prev = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (prev == charArray[i])
				block++;
			else
				block = 1;
			if (block > previoublock && block != 1) {
				previoublock = block;
				blockIndex = i - block + 1;
			}
			prev = charArray[i];
		}
		System.out.println(block);
		System.out.println(blockIndex);
	}
}
