package com.patternMatching;

public class RabinKarp {

	static int d=256;
	public static void patternSearching(String text,String pattern,int q)
	{
		int textSize= text.length();
		int patternSize=pattern.length();
		int h=1;
		int p=0;
		int t=0;
		for(int i=0;i<patternSize-1;i++)
		{
			h=(h*d)%q;
		}
		
		for(int i=0;i<patternSize;i++)
		{
			p=(p*d+ pattern.charAt(i))%q;
			t=(t*d+text.charAt(i))%q;
		}
		for(int  i=0;i<textSize-patternSize;i++)
		{
			if(p==t){
				int j=0;
			for(j=0;j<patternSize;j++)
			{
				if(pattern.charAt(j)!=text.charAt(i+j))
					break;
			}
			if(j==patternSize)
				System.out.println("pattern found at :" + i);
			}
			
			t=((d*(t-h*text.charAt(i)))+text.charAt(i+patternSize))%q;
			if(t<0)
				t=t+q;
		}
		
	}
	
	
	public static void main(String []args)
	{
		String text="aaaabadlaakla";
		String pattern="aa";
		patternSearching(text, pattern, 101);
	}
}