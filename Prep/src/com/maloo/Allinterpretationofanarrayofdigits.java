package com.maloo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Allinterpretationofanarrayofdigits {

	public static void main(String []args)
	{
		String str="abcdefghijklmnopqrstuvwxyz";
		Scanner in= new Scanner(System.in);
		int num[]={1, 1, 3, 4};
		List<String> los=new ArrayList<String>();
		for(int i=0;i<num.length;i++)
		{
			String s="";
			for(int k=0;k<i;k++)
				{
				//System.out.print(str.charAt(num[k]-1));
					s+=str.charAt(num[k]-1);
				}
			String count="";
			for(int j=i;j<num.length;j++)
			{
				count=count+num[j];
			}
			if(count!=""){
			int kl=Integer.parseInt(count);
			if(kl<26){
			s+=str.charAt(kl-1);
			los.add(s);}}
			
		}
		for(int i=0;i<los.size();i++)
		{
		System.out.print(los.get(los.size()-1-i));
		System.out.println();
		}

	}
}
