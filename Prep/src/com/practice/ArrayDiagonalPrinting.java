package com.practice;

public class ArrayDiagonalPrinting {

	public static void main(String []args)
	{
		String[][] stringArray = { { "A", "B", "C", "D","E" },
				{ "F", "G", "H", "I","J"},
				{ "K", "L", "M", "N" ,"O"},
				{ "P", "Q", "R", "S","P"},
				{ "U", "V", "W", "X","Y"} 
				};
		printDiagonal(stringArray);
	}

	private static void printDiagonal(String[][] stringArray) {
		int i=0,j=0;
		while(j<stringArray[0].length)
		{
			int col=j;
			i=0;
			while(i<stringArray.length && col>=0)
			{
				System.out.print(stringArray[i][col]);
				col--;
				i++;
			}
			System.out.println();
			j++;
		}
		i=1;
		while(i<stringArray.length)
		{
			j=stringArray[1].length-1;
			int row=i;
			while(j>=0 && row<stringArray.length)
			{
				System.out.print(stringArray[row][j]);
				j--;
				row++;
			}
			System.out.println();
			i++;
		}
		// TODO Auto-generated method stub
		
	}
}
