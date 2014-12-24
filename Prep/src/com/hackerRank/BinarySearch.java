package com.hackerRank;

import java.util.Scanner;

public class BinarySearch {
	
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int []arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=in.nextInt();
		System.out.println(binarySearch(arr,12));
	}

	private static int binarySearch(int[] arr, int num) {
		
		int low=0,high=arr.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;	
			if(arr[mid]==num)
			{
				return mid;
			}
			else if(arr[mid]<num)
			{
				low=mid+1;
			}
			else
				high=mid-1;
		}	
		return -1;
		
		
	}

}
