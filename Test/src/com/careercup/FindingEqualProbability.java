package com.careercup;

public class FindingEqualProbability {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static int getVal() {
		return 0;
	}

	public static int unbiasedGetVal() {
		int i = getVal();
		int j = getVal();
		if ((i ^ j) == 1) {
			if (i == 1)
				return 1;
			else
				return 0;
		}
		return unbiasedGetVal();
	}

}
