package com.maloo;

import java.util.Arrays;
import java.util.Scanner;

public class FindNumSumEqualToN {

	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=scanner.nextInt();
		}
		Arrays.sort(ar);
		int m=scanner.nextInt();
		int k;
		for(int i=0;i<n;i++)
		{
			k=m-ar[i];
			int left=i+1;
			int right=n-1;
			while(left<right)
			{
				if(k-ar[left]-ar[right]<0)
				{
					right--;
				}
				else if(k-ar[left]-ar[right]>0)
					left++;
					
				else{
					 System.out.println(i + " " + left + " " +right);
					 left++;
					}
			}
		}
	}
}
