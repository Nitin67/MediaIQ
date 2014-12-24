package com.careercup;

public class TeamNameGenerator {
	static int n =5,k=3;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insert("",0,0);

	}
	
	static void insert (String str, int i, int j)	{
		if( i > k-1 || j > n-k+i+1 )
			return;
		if( i < k-1)	{
			str=str+ j;
			insert(str, i+1, j+1);
			insert(str, i, j+1);
		}
		if( i == k-1)	{
			str=str+j;
			System.out.println("Team : "+str);
			insert(str, i, j+1);
		}
	}

}
