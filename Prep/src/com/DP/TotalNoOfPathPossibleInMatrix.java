package com.DP;
public class TotalNoOfPathPossibleInMatrix {

	static int totalNoOfPossiblePath(int [][]matrix)
	{
	 int [][]result= new int[matrix.length+1][matrix[0].length+1];
		for(int i=1;i<result.length;i++)
		{
			for(int j=1;j<result[0].length;j++)
			{
				if(i==1 && j==1)
				{
					result[i][j]=1;
				}
				else if(matrix[i-1][j-1]==1)
				{
					int val=0;
					if(i>=2)
					{
					if(matrix[i-2][j-1]==1)
						val=result[i-1][j];
					}
					if(j>=2)
					{
					if(matrix[i-1][j-2]==1)
						val+=result[i][j-1];
					}
					result[i][j]=val;
				}
			}
		}
		return result[matrix.length][matrix[0].length];
	}
	
	
	public static int totalPossiblePaths(int ar[][])
	{
		if (ar==null)
			return 0;
		int [][]result=new int[ar.length][ar[0].length];
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				if(i==0 || j==0)
				{
					result[i][j]=ar[i][j];
				}
				else if(ar[i][j]==1)
				{
					result[i][j]=result[i-1][j]+result[i][j-1];
				}
				else
					result[i][j]=0;
			}
		}
		
			
		return result[ar.length-1][ar[0].length-1];
	}
	
	
	public static void main(String []args)
	{
		int [][]matrix={{1,1,0,1},
						{1,1,1,1},
						{0,1,1,1},
						{1,1,1,1}
						};
		System.out.println(totalNoOfPossiblePath(matrix));
		System.out.println(totalPossiblePaths(matrix));
	}
}