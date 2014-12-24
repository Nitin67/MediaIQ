package com.patternMatching;

public class Longestrepeatedsubstring {
	public static void main(String []args)
	{
		String text="XYZAAAAAAAAA";
		System.out.println(patternMatching(text));	
	}
	public static int patternMatching(String text)
	{
		int maxx=0;
		for(int i=0;i<text.length()-1;i++)
		{
		String txt=text.substring(i, text.length());
		int lps[]=new int[txt.length()];
		lps=computeLPSArray(txt, lps);
		int max=0;
		for(int k=0;k<lps.length;k++)
		{
			max=Math.max(lps[k],max);
		}
		if(max>maxx)
			maxx=max;
		}
		return maxx;
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
}
