package com.maloo;

public class BracketProb {

	public void combinationOfBracket(String str,int len,int l,int r)
	{
		if(len==l+r)
			System.out.println(str);
		else
		{
			if(r<l)
				combinationOfBracket(str+'}', len, l, r+1);
			if(l<len/2)
				combinationOfBracket(str+'{', len, l+1, r);
		}
	}
	
	
	public static void main(String []args)
	{
		BracketProb bracketProb=new BracketProb();
		String str="";
		bracketProb.combinationOfBracket(str, 6, 0, 0);
	}
}
