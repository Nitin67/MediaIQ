package com.sorting;

public class QuickSort {
	
	public static void sort(int []ar,int left,int right)
	{
		int lhold=left,rhold=right;
		int pivot=ar[left];
		while(left<right)
		{
			while(ar[left]<pivot && left<right)
				left++;
			while(ar[right]>pivot && left<right)
				right--;
			if(left!=right)
			{
				int temp=ar[left];
				ar[left]=ar[right];
				ar[right]=temp;				
			}
		}
		ar[left]=pivot;
		pivot=left;
		left=lhold;
		right=rhold;

		if(left<pivot)
			 sort(ar,left,pivot-1);
		if(right>pivot)
			 sort(ar,pivot+1,right);

	}
	public static void main(String []args)
	{
		int []ar={1,2,3,43,12,21,32,8,67,56,9};
		sort(ar,0,ar.length-1);

		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
	}

}
