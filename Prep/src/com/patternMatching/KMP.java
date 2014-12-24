package com.patternMatching;

public class KMP {
	
	
	public static void patternMatching(String text,String pattern)
	{
		int i=0,j=0;
		int lps[]=new int[pattern.length()];
		lps=computeLPSArray(pattern, lps);
		while(i<text.length())
		{
 			if(text.charAt(i)==pattern.charAt(j))
			{
				i++;j++;
				if(j==pattern.length())
				{
					System.out.println("Pattern starts at:" + i);
					j=lps[j-1];
				}
			}
			else if(text.charAt(i)!=pattern.charAt(j))
			{
				if(j==0)
					i++;
				else
					j=lps[j-1];
			}
		}
	}
	
	public static int[] computeLPSArray(String pattern,int []lps)
	{
		int len=0;
		int i=1;
		lps[0]=0;
		while(i<pattern.length())
		{
			if(pattern.charAt(i)==pattern.charAt(len))
			{
				len++;
				lps[i++]=len;
			}
			else
			{
				if(len==0)
				{
				lps[i++]=0;
				}else
				len=lps[len-1];
			}
				
		}
		return lps;
	}
	public static void main(String []args)
	{
		String text="AABAACZAABAA";
		String pattern="AA";
		patternMatching(text, pattern);
	}

}
