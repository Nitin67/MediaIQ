package com.careercup;

public class KthLargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] givenArray = new int[]{8, 10, 15, 13, 25, 11};
		int k = 3;
		int [] output = kthLargest(givenArray,k);
		for(int a:output)
			System.out.println(a);

	}

	public static int[] kthLargest(int[] givenArray, int k) {
		int[] sortedArray = new int[k];
		for (int i = 0; i < givenArray.length; i++) {
			int temp = givenArray[i];
			for (int j = 0; j < sortedArray.length; j++) {
				if (!(sortedArray[j] == 0)) {
					int a = sortedArray[j];
					if (a < temp) {
						sortedArray[j] = temp;
						temp = a;
					}
				} else {
					sortedArray[j] = temp;
					break;
				}
			}
		}
		return sortedArray;
	}
}
