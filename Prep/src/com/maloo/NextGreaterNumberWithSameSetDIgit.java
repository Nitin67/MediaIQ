package com.maloo;

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterNumberWithSameSetDIgit {
	
	public static void nextGreaterNumberWithSameNoOfSetBits(String str)
	{
		System.out.println(str);

		char []strArray=str.toCharArray();
		int i;
		for(i=str.length()-2;i>=0;i--)
		{
			if(strArray[i+1]>strArray[i])
				break;
		}
		if(i<0)
			System.out.println("Solution not possible");
		else
		{
			char temp=strArray[i];
			strArray[i]=strArray[i+1];
			strArray[i+1]=temp;
			if(i<str.length()-2){
			String str2=str.substring(i+2);
			char []str2Array=str2.toCharArray();
			Arrays.sort(str2Array);
			for(int k=0;k<str2.length();k++)
			{
				strArray[k+i+2]=str2Array[k];
			}
			}

		}
		System.out.println(strArray);
	}
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		int num=scanner.nextInt();
		nextGreaterNumberWithSameNoOfSetBits(Integer.toBinaryString(num));
		char []strArray=str.toCharArray();
		int i;
		for(i=str.length()-2;i>=0;i--)
		{
			if(strArray[str.length()-1]>strArray[i])
				break;
		}
		if(i<0)
			System.out.println("Solution not possible");
		else
		{
			String str2=str.substring(i);
			char []str2Array=str2.toCharArray();
			Arrays.sort(str2Array);
			for(int k=0;k<str2.length();k++)
			{
				strArray[k+i]=str2Array[k];
			}
			char temp=strArray[i];
			strArray[i]=strArray[i+1];
			strArray[i+1]=temp;
		}
		System.out.println(strArray);
		String str5=new String(strArray);
		System.out.println(str5);
	}

}
