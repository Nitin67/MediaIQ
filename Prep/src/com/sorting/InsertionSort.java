package com.sorting;

public class InsertionSort {

	public static void sort(int []ar)
	{
		for(int i=1;i<ar.length;i++)
		{
			int j=i;
			
			while( j>0 && ar[j]<ar[j-1])
			{
				int temp=ar[j];
				ar[j]=ar[j-1];
				ar[j-1]=temp;
				j--;
			}
		}
	}
	
	public static void main(String []args)
	{
		int []ar={3,23,1,43,4,21};
		sort(ar);
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
	}
}
