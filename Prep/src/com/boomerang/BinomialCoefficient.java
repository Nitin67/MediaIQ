package com.boomerang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BinomialCoefficient {

	int binomialCoefficient(int n,int k)
	{
		if(k==0 || k==n)
			return 1;
		if(n==0)
			return 1;
		
		return binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
	}
	int binomialCoefficientDP(int n,int k)
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
	private int min(int i, int k) {
		return (i>k)?k:i;
	}
	public static void main(String []args)
	{
		Set<Integer> set = new HashSet<Integer>();
	      Scanner in = new Scanner(System.in);
		  	String s = in.nextLine();
		  	int k=Integer.parseInt(s);
		  	for(int j=0;j<k;j++)
		  	{
		  		s = in.nextLine();
		  		int a,b=0;
		  		StringBuilder str=new StringBuilder();
		  	for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)==' ')
				{
					
					if(str.toString()!="" && str!=null)
					{ a=Integer.parseInt(str.toString());
				
					str=new StringBuilder();
					}
				}
				else
					str.append(s.charAt(i));
				if(i==s.length()-1)
				{
					if(str.toString()!="" && str!=null)
					{ b=Integer.parseInt(str.toString());
					}
				
				}
					 
			}
		  	
			for(int l=0;l<b;l++)
		  	{
		  		s = in.nextLine();
		  		str=new StringBuilder();
		  		for(int i=0;i<s.length();i++)
				{
					if(s.charAt(i)==' ')
					{
						
						if(str.toString()!="" && str!=null)
						{ set.add(Integer.parseInt(str.toString()));
						}
						str=new StringBuilder();
					}
					else
						str.append(s.charAt(i));
					if(i==s.length()-1)
					{
						if(str.toString()!="" && str!=null)
						{  set.add(Integer.parseInt(str.toString()));
						}
					
					}
						 
				}
		  		
		  	}
		  	System.out.println(set.size()-1);
		  	}

	       
	    }
	      
}
