package com.random;

public class MergeArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		changeArr(arr);
	}
	public static void changeArr(int arr[]){
		   int temp,j=1;
		   int m=arr.length/2;
		   temp=arr[j];
		   while(j<arr.length){
		      temp=arr[j];
		      arr[j]=arr[m];
		      m++;j++;
		      if(j<arr.length){
		         arr[m-1]=arr[j];
		         arr[j]=temp;
		         temp=arr[m-1];
		         j++;
		      }else{
		    	  arr[m-2] = temp;
		      }
		   }
		}

}
