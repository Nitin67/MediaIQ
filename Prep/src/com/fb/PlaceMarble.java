package com.fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class point {
	int start;
	int end;
}

public class PlaceMarble {

	
	public static int placeMarblePosition(int [][]grid)
	{
		int x[][]=new int[grid.length][grid.length];
		int y[][]=new int[grid.length][grid.length];
		int count =0;
		for(int i=0;i<grid.length;i++)
		{
			
			int start=0,end=grid.length-1;
			while(start<grid.length && grid[i][start]==0  )
				start++;
			while( 0<=end && grid[i][end]==0)
				end--;
			while(start<end)
			{
				if(grid[i][start]==0)
					x[i][start]=1;
				
				start++;
			}
		}
		for(int i=0;i<grid.length;i++)
		{
			
			int start=0,end=grid.length-1;
			while(start<grid.length && grid[start][i]==0  )
				start++;
			while( 0<=end && grid[end][i]==0)
				end--;
			while(start<end)
			{
				if(grid[start][i]==0)
					y[start][i]=1;
				
				start++;
			}
		}
		int n=grid.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{		
				if(x[i][j]+y[i][j]==2)
					count++;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(x[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(y[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		return count;
	}
	
	public static int placeMarble(int grid[][])
	{
		int count=0;
		int n=grid.length;
		for(int i=0;i<grid.length;i++)
		{
			int start=0,end=grid.length-1;
			while(start<grid.length && grid[i][start]==0  )
				start++;
			while( 0<=end && grid[i][end]==0)
				end--;
			while(start<end)
			{
				if(grid[i][start]==0)
					grid[i][start]=2;
				
				start++;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		for(int i=0;i<grid.length;i++ )
		{
			int start=0,end=grid.length-1;
			while(start<grid.length && grid[start][i]!=1  )
				start++;
			while( 0<=end && grid[end][i]!=1)
				end--;
			while(start<end)
			{
				if(grid[start][i]==2)
					{grid[start][i]=4;
					count++;
					}
				
				start++;
			}
		}
		return count;
	}
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int grid[][]=new int[n][n];
		for(int i=0;i<k;i++)
		{
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			grid[n-1-x][y]=1;	
		}
		System.out.println();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(placeMarble(grid));
		
	}
}
