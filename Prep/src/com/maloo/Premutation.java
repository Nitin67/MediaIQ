package com.maloo;



public class Premutation {

	public static void permuteIterative(String str)
	{
		int i, j;
		int length = str.length();
		char[] local_str;
		
		for(i=0; i<length; i++){
			for(j=i; j<length; j++){
				local_str = str.toCharArray();
				char c = local_str[i];
				String temp=str.substring(0, i) + str.substring(i+1, j+1) + c + str.substring(j+1, length);
				System.out.println(temp);
			}
		}
	}
	
	public static String[] iterate3(String str)
	{
		String []str3=new String[6];
		for(int i=0;i<str.length();i++)
		{
			String str1=new String(str);
			if(i!=0)
			 str1= str.charAt(str.length()-1)+str.substring(0,str.length()-1);
			for(int j=0;j<str.length()-i;j++)
			{
				char[]local_str = str1.toCharArray();
				char temp=local_str[i];
				local_str[i]=local_str[j];
				local_str[j]=temp;
				str3[i]=local_str.toString();
				System.out.println(local_str);
			}
		}
		return str3;
	}
	public static void iterate2(String str)
	{
		System.out.println(str);
		int p[]=new int[str.length()];
		char []string=str.toCharArray();
		int i=1;
		while(i<str.length())
		{
			if(p[i]<i)
			{
				int j=0;
				if(i%2!=0)
				{
					j=p[i];
				}
				char temp=string[i];
				string[i]=string[j];
				string[j]=temp;
				System.out.println(string);
				p[i]++;
				i=1;
			}
			else
			{
				p[i]=0;
				i++;
			}
		}
	
	}
	
	public static void permuteiterate(String str)
	{
		System.out.println(str);
		int p[]=new int[str.length()+1];
		char []string=str.toCharArray();
		for(int i=0;i<=str.length();i++)
		{
			p[i]=i;
		}
		int i=1;
		while(i<str.length())
		{
			p[i]--;
			char c=string[0];
			string[0]=string[i];
			string[i]=c;
			System.out.println(string);
			i=1;
			while(p[i]==0)
			{
				p[i]=i;
				i++;
			}
		}
	}
	
	public static void main(String []args)
	{
		//iterate2("abcd");
		permuteiterate("abcd");
	}
}
