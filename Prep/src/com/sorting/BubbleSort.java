package com.sorting;

public class BubbleSort {
	
	public static void sort(int arr[])
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}

		}
	}
	public static void main(String []args)
	{
		int ar[]={3,21,53,1,43,5,2};
		sort(ar);
		for(int i:ar)
		{
			System.out.println(i);
		}
	}

}
