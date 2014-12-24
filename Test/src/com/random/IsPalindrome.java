package com.random;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aa";
		 boolean isPalindrome = isPalindrome(str);
		System.out.println(isPalindrome);
		// TODO Auto-generated method stub

	}

	private static boolean isPalindrome(String str) {
		for(int i=0,j=str.length()-1;j>=i;i++,j--){
			if(!(str.charAt(i) == str.charAt(j))){
				return false;
			}
		}
		return true;
	}

}
