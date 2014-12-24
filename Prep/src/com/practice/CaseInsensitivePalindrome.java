package com.practice;

public class CaseInsensitivePalindrome {

	public static boolean isPalindrome(String str)
	{
		int i=0,j=str.length()-1;
		while(i<j)
		{
			if(!isAlphabet(str.charAt(i)))
			{
				i++;
			}
			else if(!isAlphabet(str.charAt(j)))
			{
				j--;
			}
			else{
				if(str.charAt(i)==str.charAt(j) || Math.abs(str.charAt(i)-str.charAt(j))==('a'-'A'))
				{
					i++;j--;
				}
				else return false;
			}
		}
		return true;
	}
	private static boolean isAlphabet(char charAt) {
		if((charAt>='a' && charAt<='z') || (charAt>='A' && charAt<='Z'))
			return true;
		return false;
	}
	public static void main(String []args)
	{
		String str="Ab   B,!2@#a";
		System.out.println(isPalindrome("Ab   B,!2@#a"));
		//System.out.println(str.charAt(str.length()-1)-str.charAt(0));
	}
}
