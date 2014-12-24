



package com.careercup;

import java.util.HashSet;
import java.util.Set;

public class AllPermutationRemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 2, 2, 2 };
		int i = 0;
		Integer i1 = i;
		Integer i2 = new Integer(0);
		System.out.println(i1.hashCode() + "" + i2.hashCode());
		printAllPermutation(array, null);
		printPermutation(array);
	}

	private static void printAllPermutation(int[] array, int[] output) {
		if (output == null) {
			System.out.println("NULL");
		}
		if (array == null)
			return;
		if (output != null) {
			for (int a : output)
				System.out.print(a + "\t");
			System.out.println();
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (!set.contains(array[i])) {
				printAllPermutation(remove(array, i), add(output, array[i]));
				set.add(array[i]);
			}
		}

	}

	private static void printPermutation(int[] array) {
		System.out.println("NULL");
		if (array == null)
			return;
		for (int i = 0; i < array.length; i++) {
			if (i > 0 && array[i] == array[i - 1])
				continue;
			for (int j = i + 1; j < array.length; j++) {
				if (j > i && array[j] == array[j - 1] && j != i + 1)
					continue;
				for (int k = j + 1; k < array.length; k++) {
					if (k > j && array[k] == array[k - 1] && k != j + 1)
						continue;
					System.out.println(array[i] + "," + array[j] + ","
							+ array[k]);
				}
			}
		}
	}

	private static void printPermutation(int[] array, int[] output) {
		if (output != null) {
			for (int a : output)
				System.out.print(a + "\t");
			System.out.println();
		}
		if (array == null)
			return;
		for (int i = 0; i < array.length; i++) {
			printPermutation(remove(array, i), add(output, array[i]));
		}

	}

	private static int[] add(int[] output, int i) {
		int[] newArray = null;
		if (output == null) {
			newArray = new int[] { i };
		} else {
			newArray = new int[output.length + 1];
			int j = 0;
			for (int o : output) {
				newArray[j] = o;
				j++;
			}
			newArray[output.length] = i;
		}
		return newArray;
	}

	private static int[] remove(int[] array, int i) {
		if (array == null || array.length <= 1)
			return null;

		int[] newArray = new int[array.length - 1];
		int k = 0;
		for (int j = 0; j < array.length; j++) {
			if (i != j) {
				newArray[k] = array[j];
				k++;
			}

		}
		return newArray;
	}

}
