package com.fb;

public class OneEditString {
	
	public static boolean isOneEditAway(String str1,String str2,boolean edit,int i,int j)
	{
		if( Math.abs(str1.length()-str2.length()) >1 )
			return false;
		
		if(str1.length()==i && str2.length()==j)
			 return edit;
		else if(str2.length()==j)
		{
				if(str1.length()==i-1)
					return !edit;
				else
					return false;
		}
		else if(str1.length()==i)
		{
				if(str2.length()==j-1)
					return !edit;
				else
					return false;
		}	 
		 
		else if(str1.charAt(i)==str2.charAt(j))
		{
			return isOneEditAway(str1, str2, edit, i+1, j+1);
		}
		  
		else
		{
			if(edit)
			{
				return false;
			}
			else
			{
				return (isOneEditAway(str1, str2, !edit, i, j+1) || isOneEditAway(str1, str2, !edit, i+1, j) || isOneEditAway(str1, str2, !edit, i+1, j+1));
			}
		}
		
	}
	public static void main(String []args)
	{
		System.out.println(isOneEditAway("xyz", "xz", false, 0, 0));
		System.out.println(isOneEditAway("xz", "xyz", false, 0, 0));
		System.out.println(isOneEditAway("xaz", "xyz", false, 0, 0));
		System.out.println(isOneEditAway("abc", "abc", false, 0, 0));
		System.out.println(isOneEditAway("abc", "acb", false, 0, 0));
		System.out.println(isOneEditAway("ab", "abcd", false, 0, 0));
	}

}
