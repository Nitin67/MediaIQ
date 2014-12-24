package com.fb;

public class AddBinaryNumber {
	
	
	
	public static void main(String []args)
	{
		String str1="110",str2="101001";
		//System.out.println(str1.charAt(2));
		System.out.println(addBinaryStrings( str1, str2));
	}

	private static char[] addBinaryStrings(String str1, String str2) {
		
		char []ch=new char[str1.length()>str2.length()?str1.length()+1:str2.length()+1];
		int i=str1.length()-1,j=str2.length()-1;
		int k=ch.length-1;
		int carry=0;
		while(i>=0 || j>=0)
		{
			
			int add1=0;
					if(i>=0)
					add1=str1.charAt(i)-48;
			int add2=0;
			if(j>=0)
				add2=str2.charAt(j)-48;
			int sum=add1^add2^carry;
			carry=(add1+add2+carry)/2;
			ch[k--]=(char) (sum+48);
			
			i--;
			
			j--;
			
		
		}
		
		
		
		return ch;
	}

}
