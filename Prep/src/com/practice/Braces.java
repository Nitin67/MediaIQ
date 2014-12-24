package com.practice;

public class Braces {

	
	public static void permuteBraces(int leftindex,int rightIndex,String str)
	{
		if(leftindex==0 && rightIndex==0)
			System.out.println(str);
		else
		{
			if(leftindex>0)
				permuteBraces(leftindex-1, rightIndex, str+'{');
			if(rightIndex>0 && leftindex<rightIndex)
				permuteBraces(leftindex, rightIndex-1, str+'}');
		}
	}
	public static void main(String []args)
	{
		permuteBraces(2, 2, "");
	}
}
