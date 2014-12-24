package com.backtracking;

import java.util.Scanner;

public class StringPermutation {

	static void swap(char a,char b)
	{
		char temp=a;
		a=b;
		b=temp;
	}
	static void permute(char str[], int i, int n) {
		if(i==n)
		{
			System.out.println(str);
		}
		else
		{
			for(int j=i;j<=n;j++)
			{
				if(i==j || str[i]!=str[j])
				{
				char temp=str[i];
				str[i]=str[j];
				str[j]=temp;
				
				permute(str,i+1,n);
				temp=str[i];
				str[i]=str[j];
				str[j]=temp;
			
				
				}
				}
		}

	}

	static void permuteString(StringBuffer str, int i, int n) {
		
		if(i==n)
		{
			System.out.println(str);
		}
		else
		{
			for(int j=i;j<=n;j++)
			{
				if(i==j || str.charAt(i)!=str.charAt(j))
				{
				char temp=str.charAt(i);
				str.setCharAt(i, str.charAt(j));
				str.setCharAt(j, temp);
				
				permuteString(str,i+1,n);
				temp=str.charAt(i);
				str.setCharAt(i, str.charAt(j));
				str.setCharAt(j, temp);
				}
		
			}
		}

	}
	public static void main(String[] args) {
		System.out.println("Enter the string");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		//System.out.println(input);
		//permute(input.toCharArray(),0,input.length()-1);
		permuteString(new StringBuffer(input), 0, input.length()-1);

	}
}
