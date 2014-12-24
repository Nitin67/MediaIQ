package com.careercup;

public class NextNumberWithSameNumberOfSetBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int g = greaterNumber(5);
		int h = lesserNumber(17);
		System.out.println(Integer.toBinaryString(g));
		System.out.println(Integer.toBinaryString(h));
	}

	private static int lesserNumber(int number) {
		int i = 0;
		boolean flag = false;
		for (; i < 32; i++) {
			if (flag) {
				if (isSet(number, i)) {
					number = unsetBit(number, i);
					number = setBit(number, --i);
					break;
				}
				continue;
			}
			if (!isSet(number, i))
				flag = true;
		}
		int count = 0;
		for (int j = i - 1; j >= 0; j--) {
			if (isSet(number, j))
				count++;
		}
		for (int j = i-1; j >= i-1-count; j--)
			number = setBit(number, j);
		for (int j = i-1-count; j >= 0; j--)
			number = unsetBit(number, j);
		return number;
	}

	private static int unsetBit(int number, int i) {
		number = number & ~(1 << i);
		return number;
	}

	private static int setBit(int number, int i) {
		number = number | (1 << i);
		return number;
	}

	private static boolean isSet(int number, int i) {
		number = number & (1 << i);
		return number > 0;
	}

	private static int greaterNumber(int number) {
		int i = 0;
		boolean encounteredFlag = false;
		for (; i < 32; i++) {
			if (encounteredFlag) {
				if (!isSet(number, i)) {
					number = setBit(number, i);
					number = unsetBit(number, --i);
					break;
				}
				continue;
			}
			if (isSet(number, i)) {
				encounteredFlag = true;
			}
		}
		int count = 0;
		for (int j = i; j >= 0; j--) {
			if (isSet(number, j))
				count++;
		}
		for (int j = i; j >= count; j--)
			number = unsetBit(number, j);
		for (int j = count - 1; j >= 0; j--)
			number = setBit(number, j);
		return number;
	}

}
