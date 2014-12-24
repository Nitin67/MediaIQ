package com.adobe;

public class MaxOnesRow {

	
	public static void main(String []args)
	{
		int a[][]={{1,1,1,0,0},
				{1,1,1,1,0},
				{1,1,0,0,0},
				{1,1,1,0,0}
		};
	
		int count=0;
		int maxCountRow=0;
		int j=0;
		for(int i=0;i<a[0].length;)
		{	
			if(a[j][i]==1)
			{
				maxCountRow=j;
				count++;
				i++;
			}
			else
			{
				if(j==a.length-1)
					break;
				j++;
			}
		}
		System.out.println(maxCountRow +"---"+count);
	}
}
