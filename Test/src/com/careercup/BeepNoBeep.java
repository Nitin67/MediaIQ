package com.careercup;

public class BeepNoBeep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {2,3,2,1,2,3,4,5,6,12,45,45,4,2,1,3,1};
		beep(a);
	}

	public static void beep(int[] a) {
		int prev = 0;
		int res;
		for (int i = 0; i < a.length; i++) {
			res = prev ^ (1 << a[i]);
			if (res > prev) {
				System.out.println("beep");					
			} else {
				System.out.println("no beep");				
			}
			prev = res;
		}		
	}
}
