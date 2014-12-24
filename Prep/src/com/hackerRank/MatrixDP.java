package com.hackerRank;

public class MatrixDP {

	public static int calculatePath(int [][]matrix)
	{
		if(matrix[matrix.length-1][matrix[0].length-1]==0)
			return 0;
			
		int [][]path=new int [matrix.length][matrix[0].length];
		for(int i=0;i<matrix[0].length;i++)
		{
			path[0][i]=matrix[0][i];
		}
		for(int i=0;i<matrix.length;i++)
		{
			path[i][0]=matrix[i][0];
		}
		for(int i=1;i<matrix.length;i++)
		{
			for(int j=1;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==1){
					path[i][j]=path[i-1][j]+path[i][j-1];				
				}
				else
				{
					path[i][j]=0;
				}
			}
		}
		return path[matrix.length-1][matrix[0].length-1];
	}
	public static void main(String []args)
	{
		int [][]matrix={{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1}};
		System.out.println(calculatePath(matrix));
		
	}
}
