package com.hackerRank;

import java.util.Scanner;

public class RepetionInArray {

	
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int k=in.nextInt();
		int []ar=new int[k];
		for(int i=0;i<k;i++)
		{
			ar[i]=in.nextInt();
		}
		int a1=-1;
		int count1=0;
		int i=0;
		for(i=0;i<k;i++)
		{
			if(a1==ar[i])
				count1++;
			else if(count1==0)
				a1=ar[i];
			
			else
			{
				count1--;
			}
		}	
		System.out.println(a1+"-->"+count1);
	}
}
