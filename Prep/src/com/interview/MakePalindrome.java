package com.interview;

public class MakePalindrome {

	public static String makePalindrome(String str) 
	{
		if(isPalindrome(str))
			return null;
		int len=0;
		int i=1;
		int lps[]=new int[str.length()];
		lps[0]=0;
		while(i<str.length())
		{
			if(str.charAt(len)==str.charAt(i))
			{
				len++;
				lps[i++]=len;
			}
			else{
				if(len==0)
					lps[i++]=0;
				else
				{
					len=lps[len-1];
				}
			}
		}
		int j=0;
		int llps[]= new int[str.length()];
		for(i=(str.length()/2);i<str.length()-1;i++)
		{
			llps[i]=lps[i]-j;
			j++;
		}
		int pos=str.length()-1;
		int max=lps[str.length()-1];
		for(i=str.length()-2;i<(str.length()/2);i++)
		{
			if(llps[i]>max)
			{	max=lps[i];
				pos=i;
			}
			
		}
		System.out.println(str.length()-lps[pos]);
//		StringBuffer st= new StringBuffer(str);
		System.out.println(new StringBuilder(str.substring(lps[pos], pos)).reverse()); 
		return str.substring(lps[pos], pos);
		
	}
	
	private static boolean isPalindrome(String str) {
		for(int i=0;i<str.length()/2;i++)
			if(str.charAt(i)!=str.charAt(str.length()-1-i))
				return false;
		return true;
				
	}

	public static void main(String []args)
	{
		String str="aabaabc";
		System.out.println(makePalindrome(str).length());
	}
}
