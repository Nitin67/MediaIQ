package com.adobe;

public class IsPalindrome {

	public static int isPailndrome(int num)
	{
		int reverse=0;
		int temp=num;
		while(temp>0)
		{
			reverse=reverse*10+temp%10;
			temp=temp/10;
		}
		if(num==reverse)
			return 1;
		
		return 0;
		
	}
	
	public static void main(String []args)
	{
	System.out.println(isPailndrome(133410));	
	}
}
