package com.careercup;

public class GreyCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generateGreyCode(10);
	}

	private static void generateGreyCode(int n) {
		for(int i=0;i<=n;i++){
			int n1 = (i>>>1)^i;
			System.out.println(Integer.toBinaryString(n1)+" "+n1);
			//System.out.println(i+" "+Integer.toBinaryString(i>>>1));
		}
	}

}
