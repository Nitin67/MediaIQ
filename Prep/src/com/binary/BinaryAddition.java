package com.binary;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryAddition {

	public static String binaryAddition(String num1,String num2)
	{
		int []sum=new int[ Math.max(num1.length(), num2.length())+1];
		int k=sum.length-1;
		int carry=0;
		int i=num1.length()-1;
		int j=num2.length()-1;
		//System.out.println((int)num1.charAt(i));
		while(k>=0 && i>=0 && j>=0)
		{
			sum[k]=(((int)num1.charAt(i)-48) ^ ((int)num2.charAt(j)-48))^carry;
			carry=(((int)num1.charAt(i)-48) & ((int)num2.charAt(j)-48))|(carry&((int)num1.charAt(i)-48))|(carry&((int)num2.charAt(j)-48));
			k--;
			i--;
			j--;
		}
		while(i>=0&& k>=0)
		{
			sum[k]=(((int)num1.charAt(i)-48))^carry;
			carry=(((int)num1.charAt(i)-48))&carry;
			k--;
			i--;
		}
		while(j>=0&& k>=0)
		{
			sum[k]=((int)num2.charAt(j)-48)^carry;
			carry=((int)num2.charAt(j)-48)&carry;
			k--;
			j--;
		}
		sum[k]=carry;
		//int add= ((int)num1.charAt(num1.length()-1) ^ (int)num2.charAt(num2.length()-1));
		//int carry= ((int)num1.charAt(num1.length()-1) & (int)num2.charAt(num2.length()-1));		
		String str=Arrays.toString(sum);
		return str;
		
		
	}
	
	public static void main(String []args)
	{
		System.out.println(binaryAddition("110", "11011"));
		
	}
}
