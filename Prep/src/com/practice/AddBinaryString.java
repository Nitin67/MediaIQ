package com.practice;

public class AddBinaryString {

	
	public static void main(String []args)
	{
		System.out.println(addBinaryString("110", "11011"));
	}
	public static String addBinaryString(String str1, String str2)
	{
		int c=0;
		StringBuilder builder=new StringBuilder();
		int i=str1.length()-1,j=str2.length()-1;
		while(i>=0 || j>=0)
		{
			int sum=c;
			sum+=(i>=0)?(str1.charAt(i)-48):0;
			sum+=(j>=0)?(str2.charAt(j)-48):0;
			c=sum/2;
			sum=sum%2;
			builder.append(sum);
			i--;
			j--;
		}
		builder.append(c);
		
		builder.reverse();
		return builder.toString();
	}
}
