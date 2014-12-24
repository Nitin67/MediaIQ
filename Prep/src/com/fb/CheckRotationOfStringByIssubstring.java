package com.fb;

public class CheckRotationOfStringByIssubstring {
	
	public static boolean checkRotationOfString(String str1,String str2)
	{
		if(str1.length()!=str2.length())
			return false;
		String str11=str1+str1;
		for(int i=0;i<str2.length()-1;i++)
		 if(str11.substring(i, i+str2.length()).compareTo(str2)==0)
			 return true;
		return false;
	}
	
	public static void main(String []args)
	{
	 System.out.println(checkRotationOfString("apple", "pleap"));	
	}

}
