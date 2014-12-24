package com.careercup;


public class MatrixSpiralPrinting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[][] stringArray = { { "A", "B", "C", "D", "E" },
				{ "F", "G", "H", "I", "J" }, { "K", "L", "M", "N", "O" },
				{ "P", "Q", "R", "S", "T" }, { "U", "V", "W", "X", "Y" } };
		spiralPrinting(stringArray);
	}

	private static void spiralPrinting(String[][] stringArray) {
		if (stringArray != null) {
			int m = stringArray.length;
			int n = stringArray[0].length;
			int count = 0;
			int i=0, j=0;
			while(i<stringArray.length/2+1){
				i = count;
				j= count;
				while(j<n)
					System.out.println(stringArray[i][j++]);
				j--;
				while(i<m-1)
					System.out.println(stringArray[++i][j]);
				while(j>count)
					System.out.println(stringArray[i][--j]);
				while(i>count+1)
					System.out.println(stringArray[--i][j]);
				count++;
				n--;
				m--;
			}
		}

	}
}