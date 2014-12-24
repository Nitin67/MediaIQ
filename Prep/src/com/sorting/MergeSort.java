package com.sorting;

public class MergeSort {
	
	
	public static void sort(int []ar,int left,int right)
	{
		if(left<right)
		{
			int mid=(left+right)/2;
			sort(ar,left,mid);
			sort(ar,mid+1,right);
			merge(ar,left,mid,right);
		}
	}
	private static void merge(int[] ar, int left, int mid, int right) {
		int l=left,r=mid+1;
		int br[]= new int[ar.length];
		int k=0;
		while(l<=mid && r<=right)
		{
			if(ar[l]<ar[r])
				br[k++]=ar[l++];
			else
				br[k++]=ar[r++];
		}
		while(l<=mid)
		{
			br[k++]=ar[l++];
		}
		while(r<=right)
			br[k++]=ar[r++];
		k--;
		
		while(k>0)
		{
			ar[left+k]=br[k];
			k--;
		}
	}
	public static void main(String []args)
	{
		int []ar={1,2,3,43,12,21,32};
		sort(ar,0,ar.length-1);
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
		
	}

}
