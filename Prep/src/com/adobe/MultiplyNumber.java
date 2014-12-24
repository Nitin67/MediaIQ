package com.adobe;

public class MultiplyNumber {

	public static int multiplyNumber(int n,int m)
	{
		int mul=0;
		while(n>0)
		{
			n--;
			mul+=m;
		}
		return mul;
		
	}
	public static void main(String []args)
	{
		System.out.println(multiplyNumber(2,3));
	}
}
