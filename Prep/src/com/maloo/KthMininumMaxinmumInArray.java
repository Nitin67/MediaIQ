package com.maloo;

public class KthMininumMaxinmumInArray {

	
	public static int sort(int []ar,int left,int right,int k)
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
		if(pivot+1==k)
			return ar[pivot];
		if(left<pivot && pivot+1>k)
			return sort(ar,left,pivot-1,k);
		if(right>pivot&& pivot+1<k)
			return sort(ar,pivot+1,right,k);
		return -1;
	}
	
	

	public static void main(String []args)
	{
		int []ar={1,2,3,43,12,21,32,8,67,56,9};
		int val=sort(ar,0,ar.length-1,4);
		System.out.println("kthmin  :" + val);
		for(int i=0;i<ar.length;i++)
			System.out.println(ar[i]);
		
		int kthmax=sort(ar,0,ar.length-1,ar.length-4+1);
		System.out.println("kthmax  :"+ kthmax);
	}

}
