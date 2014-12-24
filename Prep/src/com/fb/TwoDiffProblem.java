package com.fb;

import java.util.Arrays;

public class TwoDiffProblem {

	public static boolean isDiffPossible(int ar[],int diff)
	{
		Arrays.sort(ar);
		int end=1,start=0;
		while(end<ar.length)
		{
			if(diff==(ar[end]-ar[start]))
			{
				System.out.print(ar[end]+"-"+ar[start]+ "=" +diff );
				return true;
			}
			else if(diff>(ar[end]-ar[start]))
				end++;
			else if(diff<(ar[end]-ar[start]))
				start++;
		}
		return false;
	}
	public static void main(String []args)
	{
		int ar[]={12,33,4,3,54,44,64,75,89,7,0,94,231,1};
		System.out.println(isDiffPossible(ar, 156));
	}
}
