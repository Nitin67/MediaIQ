package com.string;

public class ParseInt {
	public static void main(String []args)
	{
		String s="jnsd";
		try{
		int i=Integer.parseInt(s);
		}	
		catch(NumberFormatException e)
		{
			System.out.println(e);
		}
		}

}
