package com.recursion;

public class GenerateAllStringsOfNBits {
	
	public void generateBitArray(int n,String str,int i)
	{
		if(i==n)
			System.out.println(str);
		else
		{
			generateBitArray(n, str+'0', i+1);
			generateBitArray(n, str+'1', i+1);
		}
		
	}
	public void generateKArray(int n,String str,int i,int k)
	{
		if(i==n)
			System.out.println(str);
		else
		{
			for(int j=0;j<k;j++)
			{
			generateKArray(n, str+j, i+1, k);
			}
		}
	}
	
	public static void main(String []args)
	{
		GenerateAllStringsOfNBits allStringsOfNBits=new GenerateAllStringsOfNBits();
		String str="";
		allStringsOfNBits.generateBitArray(3, str, 0);
		allStringsOfNBits.generateKArray(2, str, 0, 11);
	}

}
