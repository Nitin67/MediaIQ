package com.sorting;

public class InsertionSort {

	private static int[] intArray = {2,34,56,2,1,234,7,89,0,1};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrayOut = insertionSort(intArray);
		for(int a:arrayOut){
			System.out.println(a);
		}
		// TODO Auto-generated method stub

	}
	private static int[] insertionSort(int[] intArray2) {
		int length = intArray2.length;
		for(int i=1;i<length;i++){
			for(int j=i;j>0;j--){
				if(intArray2[j-1]>intArray2[j]){
					int temp = intArray2[j-1];
					intArray2[j-1] = intArray2[j];
					intArray2[j] = temp;
				}
			}
		}
		return intArray2;
	}

}
