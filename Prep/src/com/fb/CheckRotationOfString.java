package com.fb;

public class CheckRotationOfString {

	public static boolean checkSubstring(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		
		 s1=s1+s1;
		 for(int i=0;i<s2.length();i++)
		 {
			
			if(s2.compareTo(s1.substring(i, i+s2.length()))==0 )
				return true;
		 }
		 return false;
		 
		
	}
	public static void main(String []args)
	{
		String str="apple";
		String str1="pleap";
		System.out.println(checkSubstring(str, str1));
	}
}
