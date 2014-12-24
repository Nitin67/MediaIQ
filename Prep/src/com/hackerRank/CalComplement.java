package com.hackerRank;

public class CalComplement {

	public static int calculateComplement(int a)
	{
		int b=~a;
		return Integer.parseInt(Long.toBinaryString(b).substring(Long.toBinaryString(b).length()-Long.toBinaryString(a).length()), 2);
				
	}
	public static void main(String []args)
	{

		System.out.println(calculateComplement(50));
	}
	


} 
