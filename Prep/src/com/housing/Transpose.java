package com.housing;

import java.util.Scanner;

public class Transpose {

	public int[][] transposeMatrix(int ar[][])
	{	
		for(int i=1;i<ar.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				int temp=ar[i][j];
				ar[i][j]=ar[j][i];
				ar[j][i]=temp;
			}
		}	
		return ar;		
	}
	
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int [][]arr=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr[i][j]=in.nextInt();
			}
		}
		Transpose transpose=new Transpose();
		int [][]ar=transpose.transposeMatrix(arr);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<ar.length/2;i++)
		{
			for(int j=0;j<n;j++)
			{
				int temp=ar[i][j];
				ar[i][j]=ar[n-1-i][j];
				ar[n-1-i][j]=temp;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
}
