package com.topcoder;

import java.util.Arrays;

public class PowerOutage {

	public static int estimateTimeOut(int []fromJunction,int []toJunction,int []ductLength)
	{
		int [][]cost=new int[fromJunction.length][fromJunction.length];
		for(int i=0;i<fromJunction.length;i++){
			
				Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		
		for(int i=0;i<fromJunction.length;i++)
		{
			cost[fromJunction[i]][toJunction[i]]=ductLength[i];
		}
		for(int i=1;i<fromJunction.length;i++)
		{
			for(int j=1;j<fromJunction.length;j++)
			{
				if(cost[0][j]>cost[0][i]+cost[i][j])
					cost[0][j]=cost[0][i]+cost[i][j];
			}
		}
		
		return 0;
		
	}
	
	public static void main(String []args)
	{
		
	}
}
