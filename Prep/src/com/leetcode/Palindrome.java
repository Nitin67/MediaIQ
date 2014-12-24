package com.leetcode;

import java.util.Scanner;

public class Palindrome {

	public static boolean isPalindrome(int num)
	{
		int k=num;
		int div=1;
		int count=1;
		while(k>10)
		{
			k=k/10;
			div*=10;
			count++;
		}
		System.out.println(div);
		k=num;
		count =count/2;
		while((count)>0)
		{
			if(k/div!=k%10)
			return false;
			
			k= (k%div)/10;
			div=div/100;
			count--;
			
		}
		return true;
	}
	
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		if(isPalindrome(num))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
		
	}
}
