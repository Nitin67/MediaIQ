package com.sorting;

public class SelectionSort {
	private static int[] intArray = {2,34,56,2,1,234,7,89,0,1};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrayOut = selectionSort(intArray);
		for(int a:arrayOut){
			System.out.println(a);
		}
		// TODO Auto-generated method stub

	}
	private static int[] selectionSort(int[] intArray2) {
		int length = intArray2.length;
		for(int i=0;i<length;i++){
			int k=i;
			for(int j=i;j<length;j++){
				if(intArray2[j]<intArray2[k]){
					k=j;
				}
			}
			if(k!=i){
				int temp = intArray2[k];
				intArray2[k] = intArray2[i];
				intArray2[i] = temp;
			}
		}
		return intArray2;
	}

}
