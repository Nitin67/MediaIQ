package com.maloo;

import java.util.Scanner;

public class PermutationWithRepetition {


	public static void permute(StringBuilder str,int i,int n)
	{
		if(i==n)
			System.out.println(str.toString());
		else
		{
			for(int k=i;k<=n;k++)
			{
				if(i==k || str.charAt(i)!=str.charAt(k)){
				char c= str.charAt(i);
				str.setCharAt(i, str.charAt(k));
				str.setCharAt(k, c);
				permute(str,i+1,n);
				c= str.charAt(i);
				str.setCharAt(i, str.charAt(k));
				str.setCharAt(k, c);			
				}
			}
		}
		
	}
	
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		StringBuilder stb= new StringBuilder(s);
		permute(stb,0,s.length()-1);
	}


}
