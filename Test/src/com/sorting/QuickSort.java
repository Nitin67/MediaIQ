package com.sorting;

public class QuickSort {
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 123, 24, 125, 0, 1232, -1 };
		quickSort(array, 0, array.length - 1);
		for(Integer in:array){
			System.out.println(in);
		}
	}

	public static void quickSort(Integer[] array, int start, int end) {
		if (start >= 0 && end >= start) {
			Integer pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1,end);
		}
	}

	public static Integer partition(Integer[] array, int start, int end) {
		int pivot = array[start];
		int pivotPosition = start;
		start++;
		while (start <= end) {
			while ((start <= end) && (array[start] < pivot)) {
				start++;
			}
			while ((end >= start) && (array[end] >= pivot)) {
				end--;
			}
			if (start > end) {
				swap(array, pivotPosition, end);
			} else {
				swap(array, start, end);
			}
		}
		return end;
	}

	public static void swap(Integer[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
