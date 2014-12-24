package com.Flipkart;

public class regex {
	
	public static boolean isMatch(String str,String ptr)
	{
		int i=0,k=0;
		if(str.length()==0 && ptr.length()!=0)
			return false;
		for (Character ch : ptr.toCharArray()) {
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			{
				if(str.charAt(i)==ch)
				{
					i++;
					k++;
				}
				else
				{
					if(isMatch(str.substring(i+1), ptr.substring(k)))
						return true;
					else
						return false;
				}
					
			}
			else if(ch=='.')
			{
				i++;
				k++;
			}
			else if(ch=='*')
			{
				if(k<ptr.length()-1 && i<str.length()-1)
				{
				if(isMatch(str.substring(i+1), ptr.substring(k))||isMatch(str.substring(i+1), ptr.substring(k+1)))
					return true;
				}
				else if(ptr.length()-1==k)
					return true;
			}
			
		}
		return true;
	}
	
	public static void main(String []args)
	{
	System.out.println(isMatch("baaaa", "a*"));	
		
	}
}
