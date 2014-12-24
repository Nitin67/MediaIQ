package com.random;

public class Bracket {

	public static void possibleBrackets(int left,int right,String str)
	{
		if(left==0 && right==0)
			System.out.println(str);
		else
		{
			if(left>0)
			possibleBrackets(left-1, right, str+"{");
			if(right>0 && left<right)
			possibleBrackets(left, right-1, str+"}");
				
		}
	}
	public static void main(String []args)
	{
		String str="";
		possibleBrackets(3, 3, str);
	}
}
