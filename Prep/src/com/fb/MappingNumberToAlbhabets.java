package com.fb;

public class MappingNumberToAlbhabets {

	public static int  mappindToAlphabets(String str)
	{
		
		if(str.length()==0 || str.length()==1)
			return 1;
		
		else
		{
			return mappindToAlphabets(str.substring(1)) +  ((Integer.parseInt(str.substring(0,2)) <=26)?mappindToAlphabets(str.substring(2)):0);
		}
	}
	
	
	public static void main(String []args)
	{
		String str="111";
		System.out.println(mappindToAlphabets(str));
		
	}
}
