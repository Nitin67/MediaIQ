package com.fb;

public class ReplaceSpaceWithval {

	public static void replaceFunc(char[] str)
	{
		int spaceCount=0;
		for(char c:str)
		{
			if(c==' ')
			spaceCount++;
		}
		char []str1=new char[str.length+2*spaceCount];
		int j=str1.length-1;
		for(int i=str.length-1;i>=0;i--)
		{
			if(str[i]==' ')
			{
				str1[j]='0';
				str1[j-1]='2';
				str1[j-2]='%';
				j-=3;
			}
			else
			{
				str1[j]=str[i];
				j--;
						
			}
		}
		System.out.println(str1);
	}
	
	public static void main(String []args)
	{
		String str="read this book";
		
		replaceFunc(str.toCharArray());
	}
}
