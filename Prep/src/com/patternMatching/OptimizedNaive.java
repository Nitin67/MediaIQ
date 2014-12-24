package com.patternMatching;

public class OptimizedNaive {
	
	
	public static void patternMatching(String text,String pattern)
	{
		int t=text.length();
		int p=pattern.length();
		if(t==0)
			return;
		int i=0;
		while(t-p>i)
		{
			int j=0;
			for(j=0;j<p;j++)
			{
				if(pattern.charAt(j)!=text.charAt(i+j))
				{
					break;
				}
			}
			if(j==p)
			{
				System.out.println("Pattern found at " + i);
			}
			
			if(j==0)
				i++;
			else{
				
			}
		}
		
	}
	
	public static void main(String []args)
	{
		
	}

}
