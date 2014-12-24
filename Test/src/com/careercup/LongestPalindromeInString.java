package com.careercup;


public class LongestPalindromeInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "askdjaskjjkswepfdsn";
		int length = longestPalindromeInString(str,0,str.length()-1);
		System.out.println(length);
	}

	private static int longestPalindromeInString(String str,int i,int j) {
			if(str==null)
				return 0;
			if(str.length()==0)
				return 0 ;
			if(str.charAt(i)==str.charAt(j)&&i==j-1)
				return 2;
			if(str.charAt(i)==str.charAt(j)&&i==j)
				return 1;
			if(str.charAt(i)==str.charAt(j))
				return longestPalindromeInString(str, i+1, j-1)+2;
		return Math.max(longestPalindromeInString(str, i+1, j), longestPalindromeInString(str, i, j-1));
		
	}

}
