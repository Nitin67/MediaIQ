package com.sorting;

public class QuickSortPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray = {2,34,56,2,1,234,7,89,0,1};
		quickSort(intArray,0,intArray.length-1);
		for(int a:intArray){
			System.out.println(a);
		}
	}

	private static void quickSort(int[] intArray, int start, int end) {
		if(start>=0&&end>=start){
			int pivotPosition = partition(intArray,start,end);
			quickSort(intArray, start, pivotPosition-1);
			quickSort(intArray, pivotPosition+1, end);
		}
	}

	private static int partition(int[] intArray, int start, int end) {
		int pivotPosition = start;
		int pivot = intArray[pivotPosition];
		start++;
		while(start<=end){
			while(start<=end && intArray[start]<pivot){
				start++;
			}
			while(end>=start && pivot <= intArray[end]){
				end--;
			}
			if(start>end){
				swap(intArray,pivotPosition,end);
			}else{
				swap(intArray,start,end);
			}
		}
		return end;
	}

	private static void swap(int[] intArray, int i, int j) {
		int temp = intArray[i];
		intArray[i] = intArray[j];
		intArray[j] = temp;
	}

}
