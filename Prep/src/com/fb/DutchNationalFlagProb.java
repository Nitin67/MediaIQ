package com.fb;

public class DutchNationalFlagProb {

	public static void dutchNationalFlagProb(int ar[])
	{
		int start=0,end=ar.length-1,mid=0;
		while(start<=mid && mid<end)
		{
			if(ar[start]==1 && ar[mid]==0)
			{
				int temp=ar[start];
				ar[start]=ar[mid];
				ar[mid]=temp;
				while(ar[start]==0)
					start++;
			}
			else if(ar[mid]==0 &&ar[start]==0)
			{
				start++;
				mid++;
			}
			else if(ar[mid]==1)
			{
				mid++;
			}
			else if(ar[mid]==2)
			{
				while(ar[end]==2)
					end--;
				if(end>mid)
				{
					int temp=ar[mid];
					ar[mid]=ar[end];
					ar[end]=temp;				
				}
			}
			
		}
		
	}
	
	
	
	public static void dutchNationalFlag(int ar[])
	{
		int start=0,mid=0;
		int end=ar.length-1;
		while(mid<end)
		{
			if(ar[mid]==0)
			{
				while(mid>start && ar[start]==0)
					start++;
				
				if(mid>start)
				{
					int temp=ar[mid];
					ar[mid]=ar[start];
					ar[start]=temp;
				}
				mid++;
			}
			else if(ar[mid]==1)
			{
				mid++;
			}
			else if(ar[mid]==2)
			{
				while(ar[end]==2)
					end--;
				if(mid<end)
				{
					int temp=ar[mid];
					ar[mid]=ar[end];
					ar[end]=temp;
				}
				
			}
				
		}
	}
	
	public static void segregateZeroOne(int ar[])
	{
		int start=0,end=ar.length-1;
		while(start<end)
		{
			while(ar[start]==0)
				start++;
			while(ar[end]==1)
				end--;
			
			if(start<end)
			{
				int temp=ar[start];
				ar[start]=ar[end];
				ar[end]=temp;
			}
		}
		System.out.println();
	}
	public static void main(String []args)
	{
		int ar[]={0,1,0,1,0,1,0,1,2,2,2,2,1,2,0,1,2,2,1,0,0,1,0,0,1,0,2,0,2};
		int a[]={1,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,0,1,0,1};
		segregateZeroOne(a);
		dutchNationalFlag(ar);
	
		for(int i:ar)
		{
			System.out.println(i);
		}
		
	}
}
