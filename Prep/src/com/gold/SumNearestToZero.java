package com.gold;

import java.util.Arrays;

public class SumNearestToZero {

	public static void findTwoNumberWithSumNearestToZero(int a[])
	{
		Arrays.sort(a);
		int i=0,j=a.length-1;
		int min=Integer.MAX_VALUE;
		int x=-1,y=-1;
		while(i<j)
		{
			
			if( Math.abs( a[i]+a[j])<min)
			{
				min=Math.abs( a[i]+a[j]);
				x=i;y=j;
			}
			if(a[i]+a[j]>0)
			{
				j--;
			}
			else if(a[i]+a[j]<0)
			{
				i++;
			}
			else
			{
				min=0;
				x=i;y=j;
				break;
			}
		}
		System.out.println("Values are :" +a[x]+"," + a[y]);
	}
	
	public static void main(String []args)
	{
		int a[]={-2,3,4,-2,4,-6,-9,-5,17,71};
		findTwoNumberWithSumNearestToZero(a);
		
	}
}
