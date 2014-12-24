package com.maloo;

public class PrintMatrixDiagonally {

	
	
	public static void main(String []args)
	{
		int [][]ar={{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,16},
					{17,18,19,20}};
		System.out.println(ar.length+ " "+ ar[0].length);
		int i=0,j=1;
		while(i<ar.length)
		{		
				int l=i,m=0;
				while(l>=0 && m<=ar[0].length-1) 
				{
					System.out.print(ar[l--][m++]+" ");
					
				}
			
			System.out.println();
			i++;
		}
		while(j<ar[0].length)
		{
			int l=ar.length-1,m=j;
			while(l>=0 && m<=ar[0].length-1)
			{
				System.out.print(ar[l--][m++]+" ");
			}
			System.out.println();
			j++;
		}
		
	}
}
