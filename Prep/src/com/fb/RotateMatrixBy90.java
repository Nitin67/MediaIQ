package com.fb;

public class RotateMatrixBy90 {

	//Rotate with Transpose
	public static void rotateMatrixBy90(int [][]ar)
	{
		
		//Transpose of Matrix
		for(int i=1,j=0;i<ar.length && j<ar[0].length;i++,j++)
		{
			int k=i,l=j;
			while(k<ar.length )
			{
			int temp=ar[k][l];
			ar[k][l]=ar[l][k];
			ar[l][k]=temp;
			k++;
		
			
			}
		}
		
		
		//Rotate matrix
		for(int i=0;i<ar.length/2;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				int temp=ar[i][j];
				ar[i][j]=ar[ar.length-1-i][j];
				ar[ar.length-1-i][j]=temp;
			}
		}
		System.out.println();
	}
	
	
	
	
	//Rotate without Transpose
	public static void rotateMatrixProb(int ar[][])
	{
		for(int i=0;i<ar.length/2;i++)
		{
			for(int j=0;j<ar.length-1-i;j++)
			{
				int temp=ar[i][j];
				ar[i][j]=ar[ar.length-1-j][i];
				ar[ar.length-1-j][i]=ar[ar.length-1-i][ar.length-1-j];
				ar[ar.length-1-i][ar.length-1-j]=ar[j][ar.length-1-i];
				ar[j][ar.length-1-i]=temp;
			}
		}
	}
	
	
	//Rotate without Transpose
	
	public static void rotateMatrix(int ar[][])
	{
		for(int i=0;i<ar.length/2;i++)
		{
			for(int j=0;j<ar.length-1-i;j++)
			{
				int temp =ar[i][j];
				ar[i][j]=ar[ar.length-1-j][i];		
				ar[ar.length-1-j][i]=ar[ar.length-1-i][ar.length-1-j];		
				ar[ar.length-1-i][ar.length-1-j]=ar[j][ar.length-1-i];		
				ar[j][ar.length-1-i]=temp;
						
			}
		}
	}
	public static void main(String []args)
	{
		 int a[][]={{1,2,3},
				{4,5,6},
				{7,8,9}
			
		};
		// rotateMatrixBy90(a);
		 rotateMatrixProb(a);
		 for(int i=0;i<a.length;i++)
		 {
			 for(int j=0;j<a.length;j++)
				 System.out.print(a[i][j]+" ");
			 
			 System.out.println();
		 }
		 System.out.println();
	}
}
