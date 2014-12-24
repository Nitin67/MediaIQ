package com.hackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Matrix{

	int x;
	int y;
	

	
}
class matrixComparatorx  implements Comparator<Matrix>
{

	@Override
	public int compare(Matrix o1, Matrix o2) {
		return (o1.x>o2.x)?1:0;
	}
	
}

 class matrixComparatory  implements Comparator<Matrix>
{
	@Override
	public int compare(Matrix o1, Matrix o2) {
		return (o1.y>o2.y)?1:0;
	}
}
public class Round4Marble {

	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		Matrix []matrix= new Matrix[k];
		for(int i=0;i<k;i++)
		{
			matrix[i]=new Matrix();
		}
		
		for(int i=0;i<k;i++)
		{
			int l=in.nextInt();
			matrix[i].x=l;
			l=in.nextInt();
			matrix[i].y=l;
		}
		matrixComparatorx x= new matrixComparatorx();
		
		Matrix []matrix1=matrix.clone();
		Arrays.sort(matrix1, x);
		matrixComparatory y= new matrixComparatory();
		
		Matrix []matrix2=matrix.clone();
		Arrays.sort(matrix2, y);
		int count=0;
		for(int i=0;i<matrix1.length-1;i++)
		{
			if(matrix1[i].x==matrix1[i+1].x)
			{
				for(int j=0;j<matrix2.length-1;j++)
				{
					if(matrix2[j].y==matrix2[j+1].y &&((matrix2[j].y<matrix1[i].y && matrix2[j].y>matrix1[i+1].y)||(matrix2[j].y>matrix1[i].y && matrix2[j].y<matrix1[i+1].y)))
					{
						if(matrix2[j].x<matrix1[i].x && matrix2[j+1].x>matrix1[i].x)
							count++;
						if(matrix2[j].x>matrix1[i].x && matrix2[j+1].x<matrix1[i].x)
							count++;
					}
				}
			}
		}
		
		
		
		System.out.println(count);
	}
}
