package com.walmart.demo;

import java.util.Scanner;

public class BracketProb {
	int count = 0;
	
	public static long catalanNumber(int n)
	{
		long []catalan= new long[(int)(n+1)];
		catalan[0]=1;
		catalan[1]=1;
		for(int i=2;i<=n;i++)
		{
			catalan[i]=0;
			for(int j=0;j<i;j++)
			catalan[i]+=catalan[j]*catalan[i-j-1];
		}
		return catalan[n];
	}

	public void printBracket(char s[], int len, int cur, int l, int r) {

		if (cur == len) {
			String str = new String(s);
			System.out.println(str + "\n");
			count++;
			return;
		}
		if (r < l) {
			s[cur] = '}';
			printBracket(s, len, cur + 1, l, r + 1);

		}

		if (l < len / 2) {
			s[cur] = '{';
			printBracket(s, len, cur + 1, l + 1, r);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter num of brac");
		String s = in.nextLine();
		System.out.println(s);
		
		int len = Integer.parseInt(s) * 2;
		System.out.println("catalan" + catalanNumber(len/2));
		// StringBuffer str = new StringBuffer(len);
		char[] str = new char[len];
		BracketProb bracketProb = new BracketProb();
		bracketProb.printBracket(str, len, 0, 0, 0);
		System.out.println("count : " + bracketProb.count);
		String strin = "   hello   hello jknfd     ";
		System.out.println(strin.trim());
	}

}
