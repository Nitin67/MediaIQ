package com.random;

public class TerenaryString4 {


public static int numberOfSubstrings(String A) {
	 	long count = 0;
		char a = 0, b = 0;
		int lengthA = 0, itrA = 0, itrB = 0,lengthB = 0,strLength = A.length();
		while (itrB < strLength) {
			char curr = A.charAt(itrB);
			if (curr == a) {
				lengthA++;
			} else if (curr == b) {
				lengthB++;
			} else if (a == 0) {
				a = curr;
				lengthA = 1;
			} else if (b == 0) {
				b = curr;
				lengthB = 1;
			} else {
				count += sum(itrB - itrA);
				char prev = A.charAt(itrB - 1);
				if(prev == b){
					while(lengthA > 0){
						char ch = A.charAt(itrA);
						if(ch == a){
							lengthA --;
						}else{
							lengthB --;
						}
						itrA ++;
					}
					a = curr;
					lengthA = 1;
				}else{
					while(lengthB > 0){
						char ch = A.charAt(itrA);
						if(ch == a){
							lengthA --;
						}else{
							lengthB --;
						}
						itrA ++;
					}
					b = curr;
					lengthB = 1;
				}
				count -= sum(itrB - itrA);
			}
			itrB++;
		}
		count += sum(itrB - itrA);
		return (int)count%1000000007;
	}
   // Method to calculate Arithematic sum.
	public static int sum(int n) {
		return n * (n + 1) / 2;
	}
public static void main(String args[]) {
		System.out.println(numberOfSubstrings("aabc"));
		System.out.println(numberOfSubstrings("abc"));
		System.out.println(numberOfSubstrings("baaccb"));
		System.out.println(numberOfSubstrings("ababaaaabba"));
		System.out.println(numberOfSubstrings("aabbbaa"));
	}
}