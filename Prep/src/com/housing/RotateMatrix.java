package com.housing;

import java.util.Scanner;

public class RotateMatrix {

	public int[][] rotateMatrix(int ar[][])
	{
		for(int i=0;i<ar.length/2;i++)
		{
			for(int j=0+i;j<ar.length-1-i;j++)
			{
				int temp=ar[i][j];
				ar[i][j]=ar[j][ar.length-1-i];
				ar[j][ar.length-1-i]=ar[ar.length-1-i][ar.length-1-j];
				ar[ar.length-1-i][ar.length-1-j]=ar[ar.length-1-j][i];
				ar[ar.length-1-j][i]=temp;
			}
		}
		return ar;
	}
	
	
	
	public static void main(String []args)
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int ar[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				ar[i][j]=in.nextInt();
			}
		}
		RotateMatrix matrix=new RotateMatrix();
		int a[][]=matrix.rotateMatrix(ar);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
			
	}
}
