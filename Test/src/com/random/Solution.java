package com.random;
public class Solution {

	private static int count = 0;
	static int numberOfSubstrings(String A) {

	    //intitialize empty chars
	    char a = '\'',b='\'';
	    int lengthA = 0, lengthB = 0,strLength = A.length(),itrA = 0, itrB=0;
	    while(itrB<strLength){
	    	char c = A.charAt(itrB);
	        if(c==a)
	           lengthA++; 
	        else if(c==b)
	           lengthB++;
	        else if(a=='\''){
	            a = c;
	            lengthA=1;
	        }else if(b=='\''){
	            b = c;
	            lengthB=1;
	        }else{
	            count = count + sum(itrB-itrA);
	            char d = A.charAt(itrB-1);
	            if(d==b){
	            	while(lengthA>0){
	                    char e = A.charAt(itrA);
	                    if(e==a)
	                        lengthA--;
	                    else
	                        lengthB--;
	                    itrA++;
	                }
	                a = c;
	                lengthA = 1;
	            }else{
	            	while(lengthB>0){
	                    char e = A.charAt(itrA);
	                    if(e==a)
	                        lengthA--;
	                    else
	                        lengthB--;
	                    itrA++;
	                }
	                b = c;
	                lengthB = 1;
	            }
	            count = count - sum(itrB-itrA);
	        }
	        itrB++;
	    }
	        count = count + sum(itrB-itrA);
	    return (int)count;
	    

	}

	public static int sum(int n){
	    return n*(n+1)/2;
	        }

public static void main(String args[]) {
		System.out.println(numberOfSubstrings("aabc"));
		System.out.println(numberOfSubstrings("abc"));
		System.out.println(numberOfSubstrings("baaccb"));
		System.out.println(numberOfSubstrings("ababaaaabba"));
		System.out.println(numberOfSubstrings("aabbbaa"));
	}
}