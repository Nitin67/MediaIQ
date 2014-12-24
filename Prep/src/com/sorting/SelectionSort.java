package com.sorting;

public class SelectionSort {
	

	public static void sort(int []ar)
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=i+1;j<ar.length;j++)
			{
				if(ar[i]>ar[j])
				{
					int temp=ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
				}
			}
		}
	}
	public static void main(String []args)
	{
		int []ar={2,23,12,34,45};	
		sort(ar);
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
	}

}
