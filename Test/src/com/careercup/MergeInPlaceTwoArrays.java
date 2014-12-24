package com.careercup;

public class MergeInPlaceTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[] { 3, 23, 45, 332, 4535, -1, -1, -1, -1 };
		int[] b = new int[] { 4, 54, 78, 4845 };
		merge(a, b);
		for (int c : a) {
			System.out.println(c);
		}
	}

	private static void merge(int[] a, int[] b) {
		int aLength = a.length;
		int bLength = b.length;
		int aElementLength = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] != -1)
				aElementLength++;
			else
				break;
		if (aElementLength + bLength <= aLength) {
			int aStart = aElementLength + bLength - 1;
			bLength--;
			aElementLength--;
			while (aStart >= 0) {
				if (aElementLength >= 0 && bLength >= 0
						&& a[aElementLength] > b[bLength]) {
					a[aStart] = a[aElementLength];
					aStart--;
					aElementLength--;
				} else if (bLength >= 0) {
					a[aStart] = b[bLength];
					bLength--;
					aStart--;
				} else
					break;
			}
		} else {
			System.out.println("A array is too short to merge");
		}

	}

}
