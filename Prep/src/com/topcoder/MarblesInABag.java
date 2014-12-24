package com.topcoder;

public class MarblesInABag {

	public static double getProbability(int redCount,int blueCount)
	{
	
		if(redCount>blueCount)
			return 0;
		else
		{
			return valcal(redCount,redCount+blueCount);
		}
		
		
	}
	public static double valcal(double redCount,double tot)
	{
		if(redCount==0)
			return 1;	
		else if(redCount<=tot/2)
		return (redCount/tot) * valcal(redCount-1,tot-2) + ((tot-redCount)/tot)*valcal(redCount,tot-2);
		else
		return 0;
		
	}
	public static int binomialCoefficientDP(int n,int k)
	{
		int c[][]=new int[n+1][k+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=min(i,k);j++)
			{
				if(j==0 || i==j)
					c[i][j]=1;
				else
					c[i][j]=c[i-1][j-1]+c[i-1][j];
			}
		}
	return c[n][k];
	}
	public static int min(int i, int k) {
		return (i>k)?k:i;
	}
	public static void main(String []args)
	{
		System.out.println(getProbability(2, 5));
	}
}
