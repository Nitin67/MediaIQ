package com.fb;


public class ReverseWordsInString {

	public static String reverseWordsInString(String str)
	{
		String []strArray=str.split("(\\s+)");
		StringBuilder stringBuilder=new StringBuilder();
		int i=0;
		while(i<strArray.length)
		{
			stringBuilder.append((new StringBuilder(strArray[i]).reverse()).toString());
			if(i!=strArray.length-1)
			{	
				stringBuilder.append(" ");
			}
			i++;
		}
		
		return stringBuilder.toString();
	}
	
	public static void main(String []args)
	{
		String str="the boy ran";
		System.out.println(reverseWordsInString(str));
	}
}
