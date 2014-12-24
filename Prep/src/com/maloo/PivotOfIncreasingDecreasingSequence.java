package com.maloo;

public class PivotOfIncreasingDecreasingSequence {

	public static int findPivot(int []ar,int left,int right) 
	{
		if(left<right)
		{
			int mid=(left+right)>>1;
			if(ar[mid]>ar[mid-1] && ar[mid]>ar[mid+1])
				return ar[mid];
			if(ar[mid]>=ar[mid-1] && ar[mid]<=ar[mid+1])
				return findPivot(ar, mid+1, right);
			if(ar[mid]<=ar[mid-1] && ar[mid]>=ar[mid+1])
				return findPivot(ar, left, mid-1);
		}
		return -1;
	}
	
	public static void main(String []args)
	{
		int ar[]={1,2,3,4,5,4,3,2,1};
		System.out.println(findPivot(ar,0,ar.length-1));
		
	}
}
