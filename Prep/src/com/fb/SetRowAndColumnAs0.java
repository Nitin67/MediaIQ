package com.fb;

public class SetRowAndColumnAs0 {

	
	public static void makeArrayRowAndColZero(int a[][])
	{
		int rowArray[]=new int[a.length];
		int colArray[]=new int[a[0].length];
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(a[i][j]==0)
				{
					rowArray[i]=1;
					colArray[j]=1;
				}
			}
		}
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				if(colArray[j]==1 || rowArray[i]==1)
				{
					a[i][j]=0;
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String []args)
	{
		int a[][]={ {1,1,1,0,0},
			     	{1,1,1,1,0},
				    {1,1,1,1,1},
				    {1,1,1,1,0}
		};
		makeArrayRowAndColZero(a);
	}
}
